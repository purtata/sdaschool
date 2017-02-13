package FCTRL3;
import java.util.Scanner;

public class Main {
	
	//autor KP

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int k=sc.nextInt();
			if (k>10) k=10;
			int silnia =countSilnia(k);
			
			int jedn=silnia%10;
			int dz = (silnia%100)/10;
			
			System.out.println(dz+" "+jedn);
		}
			
	}
	
	public static int countSilnia(int k){	{
		if (k < 2) return 1;
		else return k*countSilnia(k-1);
		}
		
	}

}
