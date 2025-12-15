package ie.atu.sw;

import static java.lang.System.out;

public class Runner {
	public static void main(String[] args) {
		// Create sample employee and reviewer
		var user = new User("Alice Murphy", Grade.EXECUTIVE, SecurityLevel.SECRET);
		var reviewer = new Reviewer("R001", "Patrick O'Flaherty", "Data Protection / GDPR");

		//1) Submit a clearance application request
		var application = SecurityManager.process(new Action.Submit(user, SecurityLevel.TOP_SECRET, "Access to sensitive IT infrastructure."));
		out.println("[Submitted]: " + application + "\n");

		//2) Assign a reviewer to the application
		application = SecurityManager.process(new Action.Assign(application, reviewer));
		out.println("[Assigned]: " + application + "\n");

		//3) Approve the application
		application = SecurityManager.process(new Action.Approve(application));
		user = application.user();
		out.println("[Approved]: " + application + "\n");
		out.println("[Updated User]: " + user);
	}
}