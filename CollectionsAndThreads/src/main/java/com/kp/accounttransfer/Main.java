package com.kp.accounttransfer;

public class Main {

	public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account("Jan", 1000);
        Account account2 = new Account("Zosia", 0);
        while(account1.getAmount()>0){

            Thread t3 =new Thread(getRunnable(account1,account2));
            Thread t4 =new Thread(getRunnable(account1,account2));

            t3.start();
            t4.start();

            t3.join();
            t4.join();

        }
	}
	
	private static Runnable getRunnable(Account a1, Account a2){
        return () -> runStart(a1, a2);
    }

    private synchronized static void runStart(Account a1, Account a2) {
        if (a1.getAmount()>0){
            a2.add(1);
            a1.minus(1);
        }
        System.out.print(a1.getName()+": "+a1.getAmount());
        System.out.println(", "+a2.getName()+": "+a2.getAmount());
    }
	
	

}
