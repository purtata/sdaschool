package PTROL;

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
			
			String result="";
			for (int j=2;j<splited.size();j++){
				result+=splited.get(j);
				result+=" ";
			}
			result+=splited.get(1);

		System.out.println(result);	
		}

	}

}
