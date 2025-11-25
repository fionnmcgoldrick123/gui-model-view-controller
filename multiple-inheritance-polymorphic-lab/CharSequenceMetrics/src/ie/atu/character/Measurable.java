package ie.atu.character;

/* 
 * Measurable is a service interface that describes the behaviours
 * of measurable character sequences.
 * 
 */

@FunctionalInterface
public interface Measurable {
	public static final int MINIMUM_LENGTH = 2; //Static class variables can be defined in an interface
	
	//As Measurable has a single abstract method, it is a functional interface
	public float getDistance(CharSequence s, CharSequence t) throws Exception;
	
	//All implementations inherit this default method
	public default float compare(CharSequence s, CharSequence t) throws Exception {
		return this.compare(s, t, MINIMUM_LENGTH);
	}
	
	//All implementations inherit this default method
	public default float compare(CharSequence s, CharSequence t, int overlap) throws Exception {
		this.isValid(s, t, overlap);
		return getDistance(s, t);
	}

	//Even private methods in interfaces are possible
	private void isValid(CharSequence s, CharSequence t, int min) throws Exception {
		if (s == null || t == null) throw new Exception("Error: empty character sequence.");
		if (s.length() < min || t.length() < min) throw new Exception("Error: character sequences must have a minimum length of " + MINIMUM_LENGTH);
	}
}