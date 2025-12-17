package ie.atu.sw;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record Patient(String id, String name, int age, String medicalHistory, List<String> scheduledAppointments) {
	
	public Patient(String name, int age, String medicalHistory, List<String> scheduledAppointments) {
		this(UUID.randomUUID().toString(), name, age, medicalHistory, scheduledAppointments);
	}
	
	public Patient{
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(medicalHistory);
		requireNonNull(scheduledAppointments);
		
		if(age < 0) {
			throw new IllegalArgumentException("age must be non negative");
		}
	}
}
