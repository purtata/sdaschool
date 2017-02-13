package Drinks;

public abstract class Drink {

	private String name;
	private double price;
	private final double cap;
	private double rest;
	private int nr;

	static int nrObj=0;
	
	Drink (String name, int price, double cap){
		this.name=name;
		this.price=price;
		this.cap=cap;
		this.rest=cap;
		nrObj++;
		this.nr=nrObj;
	}
	

	public abstract void fillGlass();
	
	public double getCap() {
		return cap;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getRest() {
		return rest;
	}

	public boolean goForNewOne(){
		return (getRest()==0); 
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRest(double rest) {
		this.rest = rest;
	}
	
	public int getNr() {
		return nr;
	}
	
	
	public void setNr(int nr) {
		this.nr = nr;
	}

	@Override
	public abstract String toString();

	public static int getNrObj() {
		return nrObj;
	}

}
