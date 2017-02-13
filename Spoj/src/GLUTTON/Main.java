package GLUTTON;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();

	    for (int i=0;i<test;i++){
	    	int result;
	    	int numberOfPeople = sc.nextInt();
	    	int boxSize = sc.nextInt();
	    	
	        int sum=0;
	        for (int j=0; j<numberOfPeople;j++){
	        	int food = sc.nextInt();
	            sum+=86400/food; //sumowanie zezartych ciastek wciagu doby
	        }
	        if (sum%boxSize!=0) {// dzielenie na pudelka
	            result=sum/boxSize+1; //jesli zostaje reszta to box dodatkowy
	        } else result=sum/boxSize;
	        System.out.println(result);
	    }
	}
}
