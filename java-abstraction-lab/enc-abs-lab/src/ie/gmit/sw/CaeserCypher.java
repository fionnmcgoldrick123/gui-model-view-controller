package ie.gmit.sw;

import java.util.Iterator;

public class CaeserCypher extends AbstractCypher {

	public byte[] doCypher(byte[] bytes, boolean encrypt) {
		int k = Integer.parseInt(super.getCypherKey().getPattern());
		for (int i = 0; i < bytes.length; i++) {
			if (encrypt) {
				bytes[i] += k;
			} else {
				bytes[i] -= k;
			}
		}
		
		return bytes;

	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
