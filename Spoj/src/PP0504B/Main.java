package PP0504B;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine(); //wywolanie po to by przeskoczyc puste pole
		for (int i =0;i<n;i++){
			String numbers=sc.nextLine();
			
			List<String> splited =Arrays.asList(numbers.split(" "));
			
			int shorterL=Math.min(splited.get(0).length(),splited.get(1).length());
						
			String result="";
			for (int j=0;j<shorterL;j++){
				result+=splited.get(0).charAt(j);
				result+=splited.get(1).charAt(j);
			}

			System.out.println(result);	
		}

	}

}
