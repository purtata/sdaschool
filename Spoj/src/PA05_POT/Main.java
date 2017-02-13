package PA05_POT;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();

	    for (int i=0;i<test;i++){
	    	int a = sc.nextInt();
	    	int b = sc.nextInt();
	        a=a%10;
	        if (a==0) a=10;
	        b=b%4;
	        if (b==0) b=4;
	        int result=(int) Math.pow(a, b);
	        System.out.println(result%10);
	    }

	}

}
