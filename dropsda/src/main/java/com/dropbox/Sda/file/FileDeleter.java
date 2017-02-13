package com.dropbox.Sda.file;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;


public class FileDeleter implements Runnable {

    private Path newFile;
    private DbxClientV2 client;

    public FileDeleter(Path path, DbxClientV2 client,String dir){

        newFile=path;
        this.client=client;
    }
    @Override
    public void run() {

    	try {
            FileMetadata metadata = (FileMetadata) client.files().delete("/"+newFile);
            		
            System.out.println("Deleted file : " +newFile+", nr of thread:"+Thread.currentThread().getId());
        } catch (DbxException e) {
            e.printStackTrace();
            System.out.println("Delete file !!!FAILURE!!! : " +newFile+", nr of thread:"+Thread.currentThread().getId());
        }

    }
}
