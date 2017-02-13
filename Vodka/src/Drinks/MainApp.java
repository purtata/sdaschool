package Drinks;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
			
			System.out.println("WITAJ W BARZE!");
			System.out.println("=====================\n");
			
			Customer klient1=null;
			while(!(klient1 != null)){
				try {
					klient1 = new Customer();
				} catch (Exception e) {
					System.out.println("Co� nie halo! Podaj prawid�owe dane!");
				}
			}			
			
			Drink drink=null;
			ArrayList<Drink> list = new ArrayList<Drink>();

				menu(klient1,drink,list); //logika menu pod spodem - masakra :/

			System.out.println("====================");
			System.out.println("PODSUMOWANIE!");
			System.out.println("Zam�wi�e� nast�puj�ce produkty:");
			double sum =0;
			for (Drink a:list){
				System.out.println(a.toString());
				sum+=a.getPrice();
			}
			System.out.println("Wydales w barze: "+sum+" z�");
			System.out.println("Nara, wypad z baru!");
	
	}
		
		
	static void menu(Customer customer, Drink drink, ArrayList<Drink> list){
		
		boolean run=true;
		while(run){
			int wybor=0;
			System.out.println("\n"+customer.toString());
			System.out.println("Co poda�? Wybierz opcje:");
			System.out.println("1. W�dka Wyborowa, 500 ml, cena 55 z�");
			System.out.println("2. Piwo Lech, 500 ml, cena 9 z�");
			System.out.println("3. Sok pomara�czowy, 1000 ml, cena 10 z�");
			System.out.println("4. Ko�cz�!");
			System.out.println("Wpisz wyb�r");
			Scanner sc=new Scanner(System.in);
			
			try {
				wybor=sc.nextInt();
			} catch (Exception e) {
				System.out.println("Co� nie halo! Podaj prawid�owe dane!");
				wybor=0;
				drink=null;
				continue;
			}
						
			if (!(customer.isAdult())&&(wybor<3)){
				System.out.println("Jeste� niepe�noletni! Zakaz picia alkoholu!");
				wybor=0;
				drink=null;
				continue;

			};
			switch (wybor){
				case 1:
						drink = new Vodka ("Wyborowa", 55, 500, 50);
					break;
				case 2:
						drink = new Beer ("Lech", 9, 500);
					break;
				case 3:
						drink = new Juice ("Sok pomara�czowy Tymbark", 10, 1000);
					break;
				case 4:
					System.out.println("Nara!");
					run=false;
					drink=null;
					break;
				default:
					System.out.println("Z�a opcja! Wybierz od nowa!");
					drink=null;
					
				}
			if(drink!=null){
				String line="";
				if (customer.getCash()<drink.getPrice()){
					Drink.nrObj--;
					wybor=0;
					customer.countCash(drink.getPrice());
					drink=null;
				}

				else {
					customer.countCash(drink.getPrice());
					System.out.println("Zam�wi�e�:");
					System.out.println(drink.toString());
					list.add(drink);
					do{
						drink.fillGlass();	
						if (drink.getRest()==0){
							drink.fillGlass();
							break;
						}
						System.out.println("Lejemy dalej?: wci�nij y lub cokolwiek opr�cz n\nWcisnij n by przerwa� polewanie!");
						line=sc.next();
						if (line.equals("n")){
							System.out.println("Na pewno? Zosta�o Ci jeszcze "+drink.getRest()+" ml do rozlania. \nJe�li koniec polewania to wci�nij y, lub cokolwiek by jednak pola�.");
							line=sc.next();
							if (line.equals("y")) break;
						}
					}while(drink!=null);
				}
			}
		}
	}
	
}

