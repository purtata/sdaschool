package com.kp.threadtest;

public class ThreadExample {
    static int i =0;

    public synchronized static int getI(){
        return i++;
    }

    public static void main(String[] args) {

        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                while(i<70){
                    System.out.println("Runnable 1: "+getI());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Runnable r2 = new Runnable(){

            @Override
            public void run() {
                while(i<70){
                    System.out.println("Runnable 2: "+getI());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Koniec");
    }

}
