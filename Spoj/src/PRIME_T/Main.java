package PRIME_T;

import java.util.Scanner;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int k=sc.nextInt();
			System.out.println((checkFirst(k))?"TAK":"NIE");
		}
		
	}
	
	public static boolean checkFirst(int n){
		if (n==2) return true;
		if ((n < 2) || (n%2==0))
			return false;
			for (int i=3; i<=(Math.sqrt(n)); i+=2)
			{
				if ((n%i==0))
				return false;
			}
		return true;
	}

}
