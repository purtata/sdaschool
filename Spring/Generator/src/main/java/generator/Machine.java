package generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Machine {
	
	@Autowired
	private Generator generator;
	
	private List<Integer> numbersList = new ArrayList<>();
	
	public List<Integer> getNumbersList() {
		return numbersList;
	}
	
	public void generateNumbers(int numbersToGen, int min, int max){
		for (int i=0; i<numbersToGen; i++){
			int result = generator.generate(min, max);
			if (isLuckyNumber(result)){
				i--;
			}else numbersList.add(result);
		
		}

	}
	
	public boolean isLuckyNumber(int number){
		return numbersList.contains(number);
	}
	
	
}
