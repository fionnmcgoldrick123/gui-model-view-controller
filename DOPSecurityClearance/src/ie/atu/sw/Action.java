package ie.atu.sw;

/*
 * Use sealed types for choices. The following instances of Action can be 
 * exhaustively enumerated by a switch or instance of expression.
 */
public sealed interface Action {
	record Submit(User user, SecurityLevel level, String reason) implements Action {};
	record Assign(Application application, Reviewer reviewer) implements Action {}
	record Approve(Application application) implements Action {}
}