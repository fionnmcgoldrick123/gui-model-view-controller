package ie.atu.sw;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record Doctor(String id, String name, String specialty, List<String> timeSlots, List<Appointment> appointments) {
	public Doctor(String name, String specialty, List<String> timeSlots, List<Appointment> appointments) {
		this(UUID.randomUUID().toString(), name, specialty, timeSlots, appointments);
	}
	
	public Doctor{
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(specialty);
		requireNonNull(timeSlots);
		requireNonNull(appointments);
	}
}
