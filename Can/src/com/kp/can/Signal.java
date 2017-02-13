package com.kp.can;

abstract class Signal {
	int min;
	int max;


	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public abstract String getName();
	
	public boolean inRange(int value){
		return (value>getMin()&&value<getMax()); //uzywamy geterów zamiast pól bo w polimorfizimie uzywa sie metod no i metody sa dla danego obiektu
	}

}
