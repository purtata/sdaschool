package factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import car.Car;
import car.Logan;
import resources.Color;
import resources.Level;
import resources.Type;

public class LoganFactory implements Factory{
	
	@Autowired
	private Level level;
	@Autowired
	private Color color;
	private Type type;
	@Autowired
	public List<Car> cars; 
	
	public LoganFactory() {
		this.type = Type.SEDAN;

	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setType(Type type) {
		switch(type){
		
		case SEDAN:
		case MCV:
			this.type=type;
		break;
	
		default:			
			System.out.println("Wrong type to this model! Set: "+ Type.SEDAN +" or "+Type.MCV );
			this.type=Type.SEDAN;
		
		break;
					
		}
	}
	
    public void produce(int n){
    	for (int i =0;i<n;i++){
    		cars.add(new Logan(level,color,type));
    	}
    }

	@Override
	public List<Car> getCars() {
		return cars;
	};

}
