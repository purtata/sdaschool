package PP0604A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test = Integer.parseInt(sc.nextLine()); //liczba testów

	    for (int i=0;i<test;i++){
	        List<Integer> listInt = new ArrayList<>();
	        List<String> listStr = new ArrayList<>();
	        int sum=0;
	        String read = sc.nextLine();
	        read=read.substring(2);
	        listStr= Arrays.asList(read.split(" "));
	        for (String string : listStr) {
	        	int parseInt = Integer.parseInt(string);
				listInt.add(parseInt);
				sum+=parseInt;
	        }
	            
	        double avg=(double)sum/(double)listInt.size(); //srednia
	        
	        int result=0;
	        double dist=100;
	        
	        for (Integer integer : listInt) {
				double tmpDist = Math.abs(avg-(double)integer);
				if (tmpDist<dist){
					dist=tmpDist;
					result= integer;
				}
			}
	        System.out.println(result);
		}
	       
	}

}
