package com.dropbox.Sda;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.dropbox.Sda.file.FileListener;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException, DbxApiException, DbxException {
    	
    	int threads=10;
    	Scanner in = new Scanner(new File("C:\\Users\\kp\\Desktop\\access.txt"));
    	String ACCESS_TOKEN=in.nextLine();
    	String accountInfo = in.nextLine();
    	String dir=in.nextLine();
    	in.close();
    	
        DbxRequestConfig config = new DbxRequestConfig(accountInfo, "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        
     // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        
     // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        FileListener listener = new FileListener(threads,dir,client);

    }

}
