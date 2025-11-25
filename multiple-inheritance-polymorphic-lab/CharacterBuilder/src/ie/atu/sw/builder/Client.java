package ie.atu.sw.builder;

public class Client {
	public static void main(String[] args) throws Exception {
		var cd = new CharacterDirector();
		
		for(int i = 33; i < 10000; i++) {
			cd.append((char) i);
		}
		
		System.out.println(cd.getCharSequence());
	}
}
