package ie.atu.sw;

/*
 * An enum is an example of Algebraic Data Type
 * Sum Type.
 */
public enum Grade { //Enums are immutable 
	DIRECTOR 			(5002, "Chief executive of the organisation"),
	EXECUTIVE 			(5001, "Member of the executive board of the organisation"),
	SENIOR_MANAGER 		(4002, "Controls or administers an organisational unit."),
	MANAGER 			(4001, "Controls or administers a group of staff."),
	PROJECT_MANAGER 	(3006, "Has overall charge of the planning and execution of a project."),
	TEAM_LEADER 		(3005, "Provides guidance, instruction, direction and leadership to an organisational group."),
	SUPERVISOR 			(3004, "Supervises a small group of staff or an activity."),
	SPECIALIST 			(3003, "Highly skilled in a specific and restricted field."),
	ANALYST 			(3002, "Skilled in a general field."),
	GRADUATE 			(3001, "A recent hire who has successfully completed a course of study or training."),
	ASSOCIATE 			(2004, "Has a limited or subordinate organisational role."),
	PART_TIME 			(2003, "Paid for only part of the working day or week."),
	CONTRACT 			(2002, "Has a fixed-term contract of employment."),
	TEMPORARY 			(2001, "Has temporary contract of employment."),
	INTERN				(1001, "A paid or unpaid student or trainee.");
	
	private int code;
	private String description;
	
	Grade(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int code() {
		return code;
	}

	public String description() {
		return description;
	}
}