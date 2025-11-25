package ie.gmit.sw;

public class VernamCypher extends AbstractCypher{

	@Override
	public byte[] doCypher(byte[] bytes, boolean encrypt) {
		String key = super.getCypherKey().getPattern();
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] ^ key.charAt(i));
		}
		
		return bytes;
		
	}

}
