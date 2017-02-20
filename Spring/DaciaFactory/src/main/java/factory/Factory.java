package factory;


import java.util.List;

import car.Car;
import resources.Color;
import resources.Level;
import resources.Type;

public interface Factory {
	
    void produce(int n);
    
	void setLevel(Level level);
	
	void setColor(Color color);
	
	void setType(Type type);
	
	List<Car> getCars();
	
}
