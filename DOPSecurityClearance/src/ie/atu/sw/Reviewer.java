package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Reviewer(String id, String name, String department, List<Application> assigned) {
	
	public Reviewer(String id, String name, String department, Application... assigned) {
		this(id, name, department, Arrays.asList(assigned)); //Use List.of(assigned) for an immutable list
	}
	
	public Reviewer(String id, String name, String department) {
		this(id, name, department, new ArrayList<Application>()); //Use List.of() for an immutable list
	}
	
	public Reviewer {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(department);
		requireNonNull(assigned);
	}
}