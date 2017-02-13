package com.dropbox.Sda.file;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dropbox.core.v2.DbxClientV2;


public class FileListener {

    private ExecutorService executor;
    private DbxClientV2 client;
    private String dir;

    public FileListener(int threads,String dir, DbxClientV2 client) throws IOException, InterruptedException {
        this.executor= Executors.newFixedThreadPool(threads);
        this.client=client;
        this.dir=dir;
        listen(dir);

    }

    public void listen(String path) throws InterruptedException, IOException {

        Path p = Paths.get(path);

        try(WatchService watch = p.getFileSystem().newWatchService()) {
            p.register(watch,ENTRY_CREATE,ENTRY_MODIFY,ENTRY_DELETE);

            WatchKey key = null;
            while (true) {
                key = watch.take();       
                Kind<?> kind = null;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                        // Get the type of the event
                        kind = watchEvent.kind();
                        if (OVERFLOW == kind) {
                            continue; // loop
                        } else if (ENTRY_CREATE == kind) {
                            // A new Path was created
                            Path newPath = ((WatchEvent<Path>) watchEvent).context();
//                            executor.submit(new FileSender(newPath,client,dir));
                            // Output
                            System.out.println("New path created: " + newPath);
                        } else if (ENTRY_MODIFY == kind) {
                            // modified
                            Path newPath = ((WatchEvent<Path>) watchEvent).context();
                            executor.submit(new FileSender(newPath,client,dir));
                            // Output
                            System.out.println("Path modified: " + newPath);
                            
                        }else if (ENTRY_DELETE == kind) {
                            // deleted
                            Path newPath = ((WatchEvent<Path>) watchEvent).context();
                            executor.submit(new FileDeleter(newPath,client,dir));
                            // Output
                            System.out.println("Path deleted: " + newPath);
                        }
                    }            	
                	
                key.reset();
            }
        }
    }
}

