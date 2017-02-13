package com.dropbox.Sda.file;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;


public class FileSender implements Runnable {

    private Path newFile;
    private DbxClientV2 client;
    private String dir;

    public FileSender(Path path, DbxClientV2 client,String dir){

        newFile=path;
        this.client=client;
        this.dir=dir;
    }
    @Override
    public void run() {

    	try {
			FileMetadata metadata1 = (FileMetadata) client.files().delete("/"+newFile);
		} catch (DbxException e1) {
			System.out.println("No file: " +newFile+" on serwer, nr of thread:"+Thread.currentThread().getId());
		}
        try (InputStream in = new FileInputStream(dir+"\\"+newFile)) {
            FileMetadata metadata = client.files().uploadBuilder("/"+newFile).uploadAndFinish(in);
            System.out.println("Sended file : " +newFile+", nr of thread:"+Thread.currentThread().getId());
        } catch (IOException | DbxException e) {
            e.printStackTrace();
            System.out.println("Sended file !!!FAILURE!!! : " +newFile+", nr of thread:"+Thread.currentThread().getId());
        }

    }
}
