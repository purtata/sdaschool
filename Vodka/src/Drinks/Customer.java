package Drinks;

import java.util.Scanner;

public class Customer {
	private String name;
	private int age;
	private double cash;
	

	public Customer () throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Podaj swoje imi�: ");
		this.name=sc.nextLine();
		System.out.println("Ile masz lat? ");
		this.age=Integer.parseInt(sc.nextLine());
		System.out.println("Ile masz kasy do przepicia? ");
		this.cash=Integer.parseInt(sc.nextLine());
	}

	public double getCash() {
		return cash;
	}

	public void countCash(double n){
		if (cash<n) System.out.println("Za ma�o masz kasy! Kup co� innego lub spadaj do domu!");
		else cash-=n;
	}

	@Override
	public String toString() {
		return "Klient Imi�: " + name + ", wiek: " + age + " lat, got�wka w portfelu: " + cash;
	}
	
	public boolean isAdult(){
		return (age>=18);
	}
	
}
