package CALC;

public class Modulo implements Operacje {
	
	String sign = "%";


	@Override
	public int operation(int a, int b) {
		return a%b;
	}


	public String getSign() {
		return sign;
	}
	

}
