package ie.atu.sw;

import static java.util.Objects.*;

import java.util.Objects;
import java.util.UUID;

public record Application(String id, User user, SecurityLevel requestedLevel, String reason, Status status, Reviewer reviewer) {
	
	public Application(User user, SecurityLevel requestedLevel, String reason, Status status, Reviewer reviewer){
		this(UUID.randomUUID().toString(), user, requestedLevel, reason, status, reviewer);
	}
	
	public Application{
		requireNonNull(id);
		requireNonNull(user);
		requireNonNull(requestedLevel);
		requireNonNull(reason);
		
		if (requestedLevel.value() < user.level().value()) {
			throw new IllegalArgumentException("Requested security level must be higher than the current level.");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Application app) {
			return Objects.equals(id, app.id);
		}else {
			return false;
		}
	}
}