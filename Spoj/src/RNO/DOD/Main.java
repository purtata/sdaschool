package RNO.DOD;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i =0;i<n;i++){
			int k=sc.nextInt();
			int []tab=new int[k];
			sc.nextLine(); //wywolanie po to by przeskoczyc puste pole
			String numbers=sc.nextLine();
			
			String []splited = numbers.split(" ");
			for (int j=0;j<tab.length;j++){
				tab[j]=Integer.parseInt(splited[j]);
			}

		System.out.println(sumArr(tab));	
		}
	}

	public static int sumArr(int[] tab) {
		int sum=0;
		for (int a:tab){
			sum+=a;
		}
		return sum;
	}

}
