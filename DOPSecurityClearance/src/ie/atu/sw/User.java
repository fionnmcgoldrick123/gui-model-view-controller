package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

/*
 * A product type. A record represents a tuple or relvar from the
 * Cartesian ** product ** of the number of fields (attributes / features)
 * multiplied by the number of rows (tuples, instances) of the type.
 */

public record User(String id, String name, Grade grade, SecurityLevel level) {
	private static final int MIN_ID_LENGTH = 36;
	
	public User(String name, Grade grade, SecurityLevel level) {
		this(UUID.randomUUID().toString(), name, grade, level);
	}
	
	public User{
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(grade);
		requireNonNull(level);
		
		if (id.length() < MIN_ID_LENGTH) { //Format like cf37e39d-6bf2-43cf-a699-cad9bc169a38
			throw new IllegalArgumentException("User ID must be a 128 bit identifier.");
		}
		
		if (name.length() == 0) {
			throw new IllegalArgumentException("User's name must have a value.");
		}
		
		if (grade.code() < Grade.ANALYST.code() && level.value() > SecurityLevel.UNTRUSTED.value()) {
			throw new IllegalArgumentException("Security level exceeds maximum limit.");
		}
	}
}