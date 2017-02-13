package Drinks;

public class Juice extends Drink {
	
	double glassCap=250;
	
	Juice(String name, int price, int cap) {
		super(name, price, cap);
	}
	
	static int nrGlass=0;
	
	public void fillGlass(){
		if (goForNewOne()) System.out.println("Pusty kartonik! Wracamy do menu!");
		else{
			if (getRest()<glassCap) glassCap=getRest();
			nrGlass++;
			System.out.println("Szklanka nr "+nrGlass+" nalana!");
			setRest(getRest() - glassCap);
			System.out.println("Zosta³o w kartonie: "+getRest()+" ml");	
		}
	}
		
	public String toString(){
		return "Sok: "+getName()+", Cena: "+getPrice()+"z³, pojemnoœæ kartonu: "+getCap()+" ml, zosta³o nam: "+getRest()+" ml, nr pozycji: "+getNr();
	}

}
