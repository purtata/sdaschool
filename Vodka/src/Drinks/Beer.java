package Drinks;

public class Beer extends Drink {
	
	private double Cup=500;
	
	Beer(String name, int price, double cap) {
		super(name, price, cap);
	}

	static int nrGlass=0;
	
	public void fillGlass(){
		if (goForNewOne()) System.out.println("Piwko puste! Wracamy do menu!");
		else{
			if (getRest()<Cup) Cup=getRest();
			nrGlass++;
			System.out.println("Kufel nr "+nrGlass+" nalany!");
			setRest(getRest() - Cup);
			System.out.println("Zosta³o w butelce: "+getRest()+" ml");	
		}
	}
		
	public String toString(){
		return "Piwko: "+getName()+", Cena: "+getPrice()+"z³, pojemnoœæ butelki: "+getCap()+" ml, zosta³o nam: "+getRest()+" ml, nr pozycji: "+getNr();
	}

}
