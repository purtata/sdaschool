package com.kp.executorservicedemo;

public class Task implements Runnable{
    int i;

    public Task(int i) {
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println("zadanie nr " + i+", watek: " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}