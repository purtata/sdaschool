package TRN;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ilosc = new Scanner(System.in);
		int x = ilosc.nextInt();
		int y = ilosc.nextInt();
		int[][] tab = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				tab[i][j] = ilosc.nextInt();
			}
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(tab[j][i] + " ");
			}
			System.out.println();
		}

	}
}
