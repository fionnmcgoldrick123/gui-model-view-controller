package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public record Venue(String id, String name, VenueType type, Country country, int capacity) {
	public static final int MIN_CAPACITY = 100;
	
	public Venue(String name, VenueType type, Country country, int capacity) {
		this(UUID.randomUUID().toString(), name, type, country, capacity);
	}
	
	public Venue{
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(type);
		requireNonNull(country);
		
		if(capacity < MIN_CAPACITY) {
			throw new IllegalStateException("A venue capacity must be at least 100");
		}
	}
}
