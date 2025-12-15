package ie.atu.sw;

enum SecurityLevel {
	UNTRUSTED		(0, "No access to classified documents or materials."),
	CONFIDENTIAL	(1, "Limited access to classified documents and materials."),
    SECRET			(2, "Access to classified and confidential documents and materials."),
    TOP_SECRET		(3, "Fully access to highly classified and critical information");
	
	private int value;
	private String description;
	
	SecurityLevel(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int value() {
		return value;
	}
    
	public String description() {
		return description;
	}
}