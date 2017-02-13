package STOS;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int i=0;
	    int[]array= new int[10]; 
	    Scanner sc= new Scanner(System.in);
	    while(true){
	    	String znak=sc.nextLine();
	    	if(znak.equals(""))break;
	        if(znak.equals("+")){
	            int a = Integer.parseInt(sc.nextLine());

	            if(i<10){
	                array[i] = a;
	                System.out.println(":)");
	                i++;
	            }else System.out.println(":(");	  
	            
	        }else if(znak.equals("-")){
	            if(i<=10 && i>0){
	                System.out.println(array[i-1]);
	                i--;
	            }
	            else
	            	System.out.println(":(");
	        }
	    }
	}

}
