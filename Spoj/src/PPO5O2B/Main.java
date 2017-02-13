package PPO5O2B;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine(); //wywolanie po to by przeskoczyc puste pole
		for (int i =0;i<n;i++){
			String numbers=sc.nextLine();
			//String neww= new StringBuilder(numbers).reverse().toString();
					
			List<String> splited =Arrays.asList(numbers.split(" "));
			Collections.reverse(splited);
			
			
			String result="";
			for (int j=0;j<=splited.size()-2;j++){
				result+=splited.get(j);
				if (j<splited.size()-2) result+=" ";
			}

		System.out.println(result);	
		}
		
	}

}
