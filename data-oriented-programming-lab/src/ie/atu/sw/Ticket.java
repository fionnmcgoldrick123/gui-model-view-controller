package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

public record Ticket(String id, Concert concert, Attendee attendee, double price, String advisory) {
	
	public Ticket(Concert concert, Attendee attendee, double price, String advisory) {
		this(UUID.randomUUID().toString(), concert, attendee, price, advisory);
	}
	
	public Ticket{
		requireNonNull(id);
		requireNonNull(concert);
		requireNonNull(attendee);
		requireNonNull(advisory);
		
		if(price < 0) {
			throw new IllegalStateException("Ticket price can not be negative");
		}
	}
	
	//A ticket may be given for free, but a ticket price cannot be negative.
}
