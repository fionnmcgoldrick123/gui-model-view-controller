package ie.atu.classic.vigenere;

import java.security.Key;

public class Vigenere {
	private char[][] tabulaRecta = {
			{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
					'V', 'W', 'X', 'Y', 'Z' },
			{ 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z', 'A' },
			{ 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
					'X', 'Y', 'Z', 'A', 'B' },
			{ 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
					'Y', 'Z', 'A', 'B', 'C' },
			{ 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
					'Z', 'A', 'B', 'C', 'D' },
			{ 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
					'A', 'B', 'C', 'D', 'E' },
			{ 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A',
					'B', 'C', 'D', 'E', 'F' },
			{ 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B',
					'C', 'D', 'E', 'F', 'G' },
			{ 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C',
					'D', 'E', 'F', 'G', 'H' },
			{ 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
					'E', 'F', 'G', 'H', 'I' },
			{ 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E',
					'F', 'G', 'H', 'I', 'J' },
			{ 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F',
					'G', 'H', 'I', 'J', 'K' },
			{ 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
					'H', 'I', 'J', 'K', 'L' },
			{ 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M' },
			{ 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
					'J', 'K', 'L', 'M', 'N' },
			{ 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O' },
			{ 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
					'L', 'M', 'N', 'O', 'P' },
			{ 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
					'M', 'N', 'O', 'P', 'Q' },
			{ 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
					'N', 'O', 'P', 'Q', 'R' },
			{ 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
					'O', 'P', 'Q', 'R', 'S' },
			{ 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
					'P', 'Q', 'R', 'S', 'T' },
			{ 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
					'Q', 'R', 'S', 'T', 'U' },
			{ 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
					'R', 'S', 'T', 'U', 'V' },
			{ 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
					'S', 'T', 'U', 'V', 'W' },
			{ 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
					'T', 'U', 'V', 'W', 'X' },
			{ 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y' } };

	private char[] keyText; // Store the cypher key as a char array for convenience

	public void setKey(String key) {
		//super.setKey(new VigenereKey(key));
	}

	/*
	 * To encrypt using the matrix, for each letter in the plain-text, one finds the
	 * intersection of the row given by the corresponding keyword letter and the
	 * column given by the plain-text letter itself to pick out the cypher-text
	 * letter.
	 * 
	 * To decrypt, use the keyword letter to pick a column of the table and then
	 * trace down the column to the row containing the cypher-text letter. The index
	 * of that row is the plain-text letter.
	 */
	public byte[] doCypher(byte[] text, boolean encrypt) {
		byte[] result = new byte[text.length];
		for (int i = 0; i < text.length; i++) {
			if (encrypt) {
				result[i] = getEncryptedCharacter(keyText[i], (char) text[i]);
			} else {
				result[i] = getDecryptedCharacter(keyText[i], (char) text[i]);
			}
		}
		return result;
	}

	/*
	 * Return the character given by the intersection of the row of the keyword
	 * character and the column of the plain-text character. If no such intersection
	 * exists, return the (unencrypted) plain-text character.
	 */
	private byte getEncryptedCharacter(char key, char plain) {
		for (int rows = 0; rows < tabulaRecta.length; rows++) {
			if (tabulaRecta[rows][0] == key) {
				for (int cols = 0; cols < tabulaRecta[rows].length; cols++) {
					if (tabulaRecta[0][cols] == plain) {
						return (byte) tabulaRecta[rows][cols];
					}
				}
			}
		}
		return (byte) plain;
	}

	/*
	 * Return the character in the first column of the row containing the cypher
	 * character that intersects with the column containing the keyword character.
	 */
	private byte getDecryptedCharacter(char key, char cypher) {
		for (int cols = 0; cols < tabulaRecta[0].length; cols++) {
			if (tabulaRecta[0][cols] == key) {
				for (int rows = 0; rows < tabulaRecta.length; rows++) {
					if (tabulaRecta[rows][cols] == cypher) {
						return (byte) tabulaRecta[rows][0];
					}
				}
			}
		}
		return (byte) cypher;
	}

	private class VigenereKey implements Key{
			private static final long serialVersionUID = 1L; //The interface Key is serializable...
			private static final String algorithmName = "Vigenere";
			private static final String keyFormat = "RAW";
			
			public VigenereKey(String key) {
				keyText = new char[key.length()];
				for (int i = 0; i < key.length();i++){
					keyText[i] = key.charAt(i);
				}
			}

			public String getAlgorithm() {
				return algorithmName;
			}

			public String getFormat() {
				return keyFormat;
			}

			public byte[] getEncoded() {
				byte[] bytes = new byte[keyText.length]; 
				for (int i = 0; i < keyText.length; i++) {
					bytes[i] = (byte) keyText[i];
				}
				return bytes;
			}
}
	
}
