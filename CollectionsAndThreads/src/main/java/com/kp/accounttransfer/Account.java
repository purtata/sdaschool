package com.kp.accounttransfer;

public class Account {
    private String name;

	private int amount;

    public Account(String name, int amount){
        this.name=name;
        this.amount=amount;
    }

    public String getName() {
    	return name;
    }
    
    public int getAmount() {
        return amount;
    }

    public void add(int i){
        amount+=i;
    }

    public void minus (int i){
        amount-=i;
    }


}
