package ie.gmit.sw;

public class StringCaeserKey implements CypherKey {

	private String key;

	public StringCaeserKey(String key) {
		super();
		this.key = key;
	}

	@Override
	public void setPattern(String key) throws CypherException {
		this.key = key;
	}

	@Override
	public String getPattern() {
		return "" + key;
	}

}