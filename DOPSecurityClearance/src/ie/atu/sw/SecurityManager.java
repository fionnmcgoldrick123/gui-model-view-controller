package ie.atu.sw;

import static ie.atu.sw.SecurityLevel.CONFIDENTIAL;
import static ie.atu.sw.SecurityLevel.SECRET;
import static ie.atu.sw.SecurityLevel.TOP_SECRET;
import static ie.atu.sw.SecurityLevel.UNTRUSTED;

import ie.atu.sw.Action.Approve;
import ie.atu.sw.Action.Assign;
import ie.atu.sw.Action.Submit;

public class SecurityManager {
	//Process any kind of security action request
	public static Application process(Action ai) {
		/*
		 * Pattern match over sealed types. Sealed classes and interfaces are sum types.
		 */
		return switch (ai) {
			case Submit sub when sub.user().grade().code() < 4000 && sub.level() == TOP_SECRET -> submit(sub);
			case Submit sub when sub.user().grade().code() < 3002 -> reject(sub);
			case Submit sub 	-> submit(sub);
			case Assign asg		-> assign(asg);
			case Approve apv 	-> approve(apv);
		};
	}
	
	//Submit a new security application
	public static Application submit(Action.Submit sub) {
		return new Application(sub.user(), sub.level(), sub.reason(), Status.PENDING, null);
	}
	
	//Reject a security application
	public static Application reject(Action.Submit sub) {
		return new Application(sub.user(), sub.level(), sub.reason(), Status.REJECTED, null);
	}

	//Assign an application to a reviewer
	public static Application assign(Action.Assign asg) {
		var app = asg.application();
		var rev = asg.reviewer();
		rev.assigned().add(app); //This only works because Reviewer uses a mutable list
		
		/*
		 * This type of code will be replaced by "withers" when JEP 468
		 * is rolled out. Probably Java 25. See https://openjdk.org/jeps/468
		 * 
		 * A wither method is an immutable analogue of a setter method. We will
		 * be able to "update" a record by deriving a new record using the "with"
		 * keyword. 
		 */
		rev = new Reviewer(rev.id(), rev.name(), rev.department(), rev.assigned());
		return new Application(app.id(), app.user(), app.requestedLevel(), app.reason(), Status.PENDING, rev);
	}

	//Approve an application
	public static Application approve(Action.Approve apv) {
		var app = apv.application();
		var user = app.user();
		
		if (app.status() == Status.REJECTED) {
			throw new IllegalStateException("Application has already been rejected.");
		}
		
		/*
		 * Pattern match over enums. Enums are sum types.
		 */
		var max =  switch (user.grade()) {
			case INTERN, TEMPORARY, CONTRACT, PART_TIME, ASSOCIATE	-> UNTRUSTED;
			case GRADUATE, ANALYST, SPECIALIST 						-> CONFIDENTIAL;
			case SUPERVISOR, TEAM_LEADER, PROJECT_MANAGER, MANAGER 	-> SECRET;
			case SENIOR_MANAGER, EXECUTIVE, DIRECTOR 				-> TOP_SECRET;
		};
		
		if (app.requestedLevel().value() > max.value()) {
			throw new IllegalStateException("Requested security level exceeds maximum limit.");
		}
		
		
		/*
		 * The rest of the code in this method can be simplified when wither methods
		 * become available.
		 *
		 *
		 * The record Reviewer is shallowly immutable, so we can change this field's state 
		 */
		app.reviewer().assigned().remove(app); //This only works because Reviewer uses a mutable list
		
		//Update employee's clearance level
		user = new User(user.id(), user.name(), user.grade(), app.requestedLevel());
		
		//Update the application status to approved
		app = new Application( app.id(), user, app.requestedLevel(), app.reason(), Status.APPROVED, app.reviewer());

		return app; 
	}
	
	
	//Reject an application
	public static Application reject(Application app) {
		if (app.status() != Status.PENDING) {
			throw new IllegalStateException("Application is not in a PENDING status.");
		}
		
		//The record Reviewer is shallowly immutable, so we can change this field's state
		app.reviewer().assigned().remove(app);

		return new Application(app.id(), app.user(), app.requestedLevel(), app.reason(), Status.REJECTED, app.reviewer());
	}
}