
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import car.Car;
import config.Config;
import factory.Factory;
import resources.Color;
import resources.Level;
import resources.Type;


public class Main {

	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Factory factory = context.getBean(Factory.class);
        
        factory.produce(2);
        factory.setLevel(Level.OPEN);
        factory.setColor(Color.BROWN);
        factory.produce(1);
        factory.setType(Type.STEPWAY);
        factory.produce(2);
        factory.setColor(Color.BLACK);
        factory.setType(Type.VAN);
        factory.setLevel(Level.LAUREATE);
        factory.produce(2);
        
        for (Car car : factory.getCars()) {
			System.out.println(car.toString());
		}
	}

}
