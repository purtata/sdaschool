package CALC;

public class Dzielenie implements Operacje {

	String sign = "/";

	public String getSign() {
		return sign;
	}

	@Override
	public int operation(int a, int b){
		return a/b;
	}

}
