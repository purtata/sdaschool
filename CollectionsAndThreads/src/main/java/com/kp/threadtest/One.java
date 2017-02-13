package com.kp.threadtest;

public class One implements Runnable{
    private Integer i;
    String name;
    public One(String name, Integer i){
        this.name=name;
        this.i=i;
    }

    @Override
    public void run() {
        while(i<999){
            System.out.println("Watek "+name+" "+i++);
        }

    }
}
