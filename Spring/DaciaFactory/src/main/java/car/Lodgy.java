package car;

import resources.AirCond;
import resources.Color;
import resources.Engine;
import resources.Level;
import resources.Type;

public class Lodgy implements Car{
	
	private Type type;
	private Level level;
	private Engine engine;
	private AirCond aircond;
	private Color color;
	
	public Lodgy(Level level, Color color){
		this.level=level;
		this.color=color;
		this.type=Type.VAN;
		setProperties(level);
	
	}
	
	private void setProperties(Level level){
		
		switch(level){
		
		case ACCESS:
			this.engine=Engine.SCE16;
			this.aircond=AirCond.NONE;
		break;
		
		case OPEN:
			this.engine=Engine.TCE12;
			this.aircond=AirCond.MANUAL;			
		break;
		
		case LAUREATE:			
			this.engine=Engine.TCE12;
			this.aircond=AirCond.AUTOMATIC;			
		break;
					
		}
	}
	
    @Override
    public String toString() {
        return "New Dacia Lodgy " + type +" " + level + " engine: " + engine.getName() + " color: " + color + " aircondition: "+aircond;
    }
}
