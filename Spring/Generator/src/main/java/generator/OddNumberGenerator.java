package generator;


public class OddNumberGenerator implements Generator{

	@Override
	public int generate(int min, int max) {
		int range = (max - min) + 1;
		int result = (int)(Math.random()*range)+min;
		if (result%2!=0) return result;
		else return generate(min, max);		
	}
}
