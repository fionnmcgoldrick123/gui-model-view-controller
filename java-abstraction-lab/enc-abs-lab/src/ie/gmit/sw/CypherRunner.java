package ie.gmit.sw;

public class CypherRunner {
	public static void main(String[] args) throws CypherException {
		Cypherable cc = new VernamCypher();
		CypherKey ck = new StringCaeserKey("HEBFJKEWFKWOW293132DWDWQDW171718191D11");
		cc.setCypherKey(ck); 
		
		String s = "Happy days";
		String t = cc.encrypt(s);
		
		System.out.println(t);
		System.out.println(cc.decrypt(t));
	}
}
