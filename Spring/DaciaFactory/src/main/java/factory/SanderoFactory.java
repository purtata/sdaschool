package factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import car.Car;
import car.Sandero;
import resources.Color;
import resources.Level;
import resources.Type;

public class SanderoFactory implements Factory{
	
	@Autowired
	private Level level;
	@Autowired
	private Color color;
	private Type type;
	@Autowired
	public List<Car> cars; 
	
	public SanderoFactory() {
		this.type = Type.HATCHBACK;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setType(Type type) {
		switch(type){
		
		case HATCHBACK:
		case STEPWAY:
			this.type=type;
		break;
	
		default:			
			System.out.println("Wrong type to this model! Set: "+ Type.HATCHBACK +" or "+Type.STEPWAY );
			this.type=Type.HATCHBACK;
		
		break;
					
		}
	}

    public void produce(int n){
    	for (int i =0;i<n;i++){
    		cars.add(new Sandero(level,color,type));
    	}
    }

	@Override
	public List<Car> getCars() {
		return cars;
	};

}
