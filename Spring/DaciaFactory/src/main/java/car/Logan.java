package car;

import resources.AirCond;
import resources.Color;
import resources.Engine;
import resources.Level;
import resources.Type;

public class Logan implements Car{
	
	private Type type;
	private Level level;
	private Engine engine;
	private AirCond aircond;
	private Color color;
	
	public Logan(Level level, Color color, Type type){
		this.level=level;
		this.color=color;
		this.type=type;
		setProperties(level);
	
	}
	
	private void setProperties(Level level){
		
		switch(level){
		
		case ACCESS:
			this.engine=Engine.MPI75;
			this.aircond=AirCond.NONE;
		break;
		
		case OPEN:
			this.engine=Engine.TCE09;
			this.aircond=AirCond.MANUAL;			
		break;
		
		case LAUREATE:			
			this.engine=Engine.TCE09;
			this.aircond=AirCond.AUTOMATIC;			
		break;
					
		}
	}
	
    @Override
    public String toString() {
        return "New Dacia Logan " + type +" " + level + " engine: " + engine.getName() + " color: " + color + " aircondition: "+aircond;
    }
}
