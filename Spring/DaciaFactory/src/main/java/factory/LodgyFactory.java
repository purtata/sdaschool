package factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import car.Car;
import car.Lodgy;
import resources.Color;
import resources.Level;
import resources.Type;

public class LodgyFactory implements Factory{

	@Autowired
	private Level level;
	@Autowired
	private Color color;
	@Autowired
	public List<Car> cars; 
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}


    public void produce(int n){
    	for (int i =0;i<n;i++){
    		cars.add(new Lodgy(level,color));
    	}
    }

	@Override
	public List<Car> getCars() {
		return cars;
	};

	@Override
	public void setType(Type type) {
		System.out.println("Lodgy have only one type: VAN");
		
	};
}
