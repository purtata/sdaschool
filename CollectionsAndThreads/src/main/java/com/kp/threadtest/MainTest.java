package com.kp.threadtest;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
               
        Integer a = 222;
        Integer b = 222;
        System.out.println(a.intValue()==b.intValue());

        Integer i = new Integer(1);

        One pierwszy = new One("pierwszy",i);
        One drugi = new One ("drugi",i);

        Thread t1 =new Thread(pierwszy);
        Thread t2 =new Thread(drugi);

        t1.start();

        t2.start();

        t1.join();

        t2.join();


        System.out.println("end i "+i);


    }


}


