package ie.atu.sw;

enum Status {
    PENDING		(101, "Application under review."),
    APPROVED	(201, "Application has been approved."),
    REJECTED	(301, "Application has been rejected.");
    
    private int code;
	private String description;
	
	Status(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public double code() {
		return code;
	}
    
	public String description() {
		return description;
	}
}