package ie.gmit.sw;

public interface Cypherable {
	
	CypherKey getCypherKey();
	void setCypherKey(CypherKey cypherKey);

	byte[] encrypt(byte[] plainText) throws CypherException;

	byte[] decrypt(byte[] cypherText) throws CypherException;
	
	public default String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}

	public default String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

}