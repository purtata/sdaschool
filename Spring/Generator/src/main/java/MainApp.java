import config.Config;
import generator.Machine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Machine machine = context.getBean(Machine.class);
        machine.generateNumbers(4, -10, 10);
        
        for (int number : machine.getNumbersList()) {
			System.out.println(number);
		}

        System.out.println(machine.isLuckyNumber(-1));
        System.out.println(machine.isLuckyNumber(3));
        System.out.println(machine.isLuckyNumber(6));
        System.out.println(machine.isLuckyNumber(-6));
 
    }
}
