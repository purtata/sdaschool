package resources;

public enum Engine {
	MPI75("1.2 75KM FUEL"), TCE09("0.9 TURBO 90KM FUEL"), SCE16("1.6 115KM FUEL"), TCE12("1.2 TURBO 125KM FUEL"), DCI15("1.5 90KM DIESEL");
	
	
	  private String engineName; 

	  Engine (String name) {
	    engineName = name;
	  }

	  public String getName() {
	    return engineName;
	  }
}
