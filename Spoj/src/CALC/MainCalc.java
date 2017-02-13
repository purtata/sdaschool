package CALC;

import java.util.Scanner;

public class MainCalc {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			
			Operacje[] ops = new Operacje[5];
			ops[0]= new Dodawanie();
			ops[1]= new Odejmowanie();
			ops[2]= new Mnozenie();
			ops[3]= new Dzielenie();
			ops[4]= new Modulo();

			while(sc.hasNext()){
				Operacje op = search(ops,sc.next());
				try {
					System.out.println(op.operation(sc.nextInt(), sc.nextInt()));
				} catch (Exception e) {
					System.out.println("Koniec przetwarzania");
					break;
					}
				}
	}


	public static Operacje search(Operacje[] ops, String odczyt) {

		Operacje result=null;
		for ( Operacje a : ops){
			if (a.getSign().equals(odczyt)) return a;
		}
		return result;
	}
}

