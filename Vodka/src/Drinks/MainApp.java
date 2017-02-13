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
					System.out.println("Coœ nie halo! Podaj prawid³owe dane!");
				}
			}			
			
			Drink drink=null;
			ArrayList<Drink> list = new ArrayList<Drink>();

				menu(klient1,drink,list); //logika menu pod spodem - masakra :/

			System.out.println("====================");
			System.out.println("PODSUMOWANIE!");
			System.out.println("Zamówi³eœ nastêpuj¹ce produkty:");
			double sum =0;
			for (Drink a:list){
				System.out.println(a.toString());
				sum+=a.getPrice();
			}
			System.out.println("Wydales w barze: "+sum+" z³");
			System.out.println("Nara, wypad z baru!");
	
	}
		
		
	static void menu(Customer customer, Drink drink, ArrayList<Drink> list){
		
		boolean run=true;
		while(run){
			int wybor=0;
			System.out.println("\n"+customer.toString());
			System.out.println("Co podaæ? Wybierz opcje:");
			System.out.println("1. Wódka Wyborowa, 500 ml, cena 55 z³");
			System.out.println("2. Piwo Lech, 500 ml, cena 9 z³");
			System.out.println("3. Sok pomarañczowy, 1000 ml, cena 10 z³");
			System.out.println("4. Koñczê!");
			System.out.println("Wpisz wybór");
			Scanner sc=new Scanner(System.in);
			
			try {
				wybor=sc.nextInt();
			} catch (Exception e) {
				System.out.println("Coœ nie halo! Podaj prawid³owe dane!");
				wybor=0;
				drink=null;
				continue;
			}
						
			if (!(customer.isAdult())&&(wybor<3)){
				System.out.println("Jesteœ niepe³noletni! Zakaz picia alkoholu!");
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
						drink = new Juice ("Sok pomarañczowy Tymbark", 10, 1000);
					break;
				case 4:
					System.out.println("Nara!");
					run=false;
					drink=null;
					break;
				default:
					System.out.println("Z³a opcja! Wybierz od nowa!");
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
					System.out.println("Zamówi³eœ:");
					System.out.println(drink.toString());
					list.add(drink);
					do{
						drink.fillGlass();	
						if (drink.getRest()==0){
							drink.fillGlass();
							break;
						}
						System.out.println("Lejemy dalej?: wciœnij y lub cokolwiek oprócz n\nWcisnij n by przerwaæ polewanie!");
						line=sc.next();
						if (line.equals("n")){
							System.out.println("Na pewno? Zosta³o Ci jeszcze "+drink.getRest()+" ml do rozlania. \nJeœli koniec polewania to wciœnij y, lub cokolwiek by jednak polaæ.");
							line=sc.next();
							if (line.equals("y")) break;
						}
					}while(drink!=null);
				}
			}
		}
	}
	
}

