package ie.atu.sw;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

public record Appointment(String id, String docID, String patientID, LocalDate date, Status status) {
	public Appointment(String docID, String patientID, LocalDate date, Status status) {
		this(UUID.randomUUID().toString(), docID, patientID, date, status);
	}
	
	public Appointment{
		requireNonNull(id);
		requireNonNull(docID);
		requireNonNull(patientID);
		requireNonNull(date);
		requireNonNull(status);
		
		//Validation
	}
}
