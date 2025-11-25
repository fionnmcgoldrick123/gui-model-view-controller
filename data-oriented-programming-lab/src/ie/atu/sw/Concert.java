package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record Concert(String id, Artist artist, LocalDateTime date, Venue venue) {

	public Concert(Artist artist, LocalDateTime date, Venue venue) {
		this(UUID.randomUUID().toString(), artist, date, venue);
	}
	
	public Concert{
		requireNonNull(id);
		requireNonNull(artist);
		requireNonNull(date);
		requireNonNull(venue);
		
		if(date.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("The concert date must be in the future");
		}
	}
	
	
}
