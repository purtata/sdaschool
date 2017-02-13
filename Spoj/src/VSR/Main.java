package VSR;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = Integer.parseInt(sc.next());
	    for (int i=0; i<test; i++){
	    	int v1 = Integer.parseInt(sc.next());
	    	int v2 = Integer.parseInt(sc.next());
	        System.out.println(2*v1*v2/(v1+v2));
	    }
	}

}
