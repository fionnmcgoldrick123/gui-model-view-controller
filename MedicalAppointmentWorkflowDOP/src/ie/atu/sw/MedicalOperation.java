package ie.atu.sw;

public interface MedicalOperation {
	//Book Appointment
	//Cancel Appointment

	record Book(Patient patient, Doctor doctor) implements MedicalOperation{
		
	}
}
