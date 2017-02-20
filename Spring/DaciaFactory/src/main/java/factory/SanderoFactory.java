package factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import car.Car;
import car.Sandero;
import resources.Color;
import resources.Level;
import resources.Type;

@Component
@Profile("sandero")
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
