package com.kp.executorservicedemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Executor {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args)  {

        new Executor().start();
    }

    private void start()  {

        for (int i = 0; i < 2000; i++) {
            executor.submit(new Task(i));
        }

    }

}
