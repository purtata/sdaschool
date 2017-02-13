package PP0506A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
	
		for (int i=0;i<m;i++){
			int n = sc.nextInt();
			sc.nextLine();
			List <Point> points=new ArrayList<>();
			for(int j=0;j<n;j++){
				String [] linia=sc.nextLine().split(" ");
				Point punkt = new Point (linia[0],Integer.parseInt(linia[1]),Integer.parseInt(linia[2]));
				points.add(punkt);
			}
			
			points=sort(points,points.size());

			for (Point a:points){
				System.out.println(a.toString()+" "+a.distance);
			}
	
		}

	}
	
	public static List<Point> sort(List <Point> lista, int n){
		List <Point> list =lista;
		
		for (int i=1; i<n; i++){
			for (int j=n-1; j>=1; j--){
				Point point1 = list.get(j);
				double distance1 = point1.getDistance();
				Point point2 = list.get(j-1);
				double distance2 = point2.getDistance();
				if (distance1<distance2){
					 Point bufor=point2;
					 list.set(j-1, point1);
					 list.set(j, bufor);
				}
			 }	
		 }
		 return list;
	}

}
