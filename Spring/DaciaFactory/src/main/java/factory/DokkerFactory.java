package factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import car.Car;
import car.Dokker;
import resources.Color;
import resources.Level;
import resources.Type;

@Component
@Profile("dokker")
public class DokkerFactory implements Factory{
	
	@Autowired
	private Level level;
	@Autowired
	private Color color;
	private Type type;
	@Autowired
	public List<Car> cars; 
	
	public DokkerFactory() {
		this.type = Type.VAN;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setType(Type type) {
		switch(type){
		
		case VAN:
		case STEPWAY:
			this.type=type;
		break;
	
		default:
			this.type=Type.VAN;
			System.out.println("Wrong type to this model! Set: "+ Type.VAN +" or "+Type.STEPWAY );
		
		break;
					
		}	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	
    public void produce(int n){
    	for (int i =0;i<n;i++){
    		cars.add(new Dokker(level,color,type));
    	}
    }

	@Override
	public List<Car> getCars() {
		return cars;
	};

}
