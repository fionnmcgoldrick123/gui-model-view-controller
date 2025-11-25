package ie.gmit.sw;

public abstract class AbstractCypher implements Cypherable {

	private CypherKey key;

	public AbstractCypher() {
		super();
	}

	public abstract byte[] doCypher(byte[] bytes, boolean encrypt);

	public byte[] encrypt(byte[] plainText) throws CypherException {
		doCypher(plainText, true);
		return plainText;
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		doCypher(cypherText, false);
		return cypherText;
	}

	public CypherKey getCypherKey() {
		return key;
	}

	public void setCypherKey(CypherKey cypherKey) {
	    this.key = cypherKey;
	}

}