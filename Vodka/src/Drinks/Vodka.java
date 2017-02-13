package Drinks;

public class Vodka extends Drink {

	private double glassCap;
		
	
	Vodka(String name, int price, double cap, double glassCap) {
		super(name, price, cap);
		this.glassCap=glassCap;
	}

	static int nrGlass=0;
	
	public void fillGlass(){
		if (goForNewOne()) System.out.println("Pusta butelka! Wracamy do menu!");
		else{
			if (getRest()<glassCap) glassCap=getRest();
			nrGlass++;
			System.out.println("Kieliszek nr "+nrGlass+" nalany!");
			setRest(getRest() - glassCap);
			System.out.println("Zosta�o w butelce: "+getRest()+" ml");	
		}
	}
		
	public String toString(){
		return "W�dka: "+getName()+", Cena: "+getPrice()+"z�, pojemno�� butelki: "+getCap()+" ml, zosta�o nam: "+getRest()+" ml, nr pozycji: "+getNr();
	}

}
