package JHTMLLET;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		while(true){
			String read=sc.nextLine();
			String []splited = read.split("");
			String result ="";
			boolean flag = false;
			for (String s : splited) {
				if (s.equals("<")) flag=true;
				if (s.equals(">")) flag = false;
				if (flag) s=s.toUpperCase();
				result+=s;
			}			
			list.add(result);
			if (read.equals("</html>")) break;
		}
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
