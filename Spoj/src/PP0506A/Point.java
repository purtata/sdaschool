package PP0506A;

public class Point {
	String name;
	int x;
	int y;
	double distance;
	public Point(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.distance=countDistance(x,y);
	}
	
	public double countDistance(int x, int y){
		
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}

	@Override
	public String toString() {
		return name + " " + x + " " + y;
	}

	public double getDistance() {
		return distance;
	}

}
