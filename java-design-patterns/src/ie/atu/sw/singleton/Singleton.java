package ie.atu.sw.singleton;

public class Singleton {
	
	private static Singleton instance;
	
	//private constructor (so Singleton can't be instantiated)
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton(); // make singleton if it does not exist
		}
		
		return instance;
	}
	
	
	
}
