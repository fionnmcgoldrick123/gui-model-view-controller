package ie.atu.sw.builder;

import java.util.ServiceLoader;
import ie.atu.character.*;
import ie.atu.sw.hamming.*;

public class CharacterDirector implements FuzzyMeasurable, NormalizedMeasurable {
	private Measurable measurable;
	private CharArrayBuilder builder = new CharArrayBuilder();

	public CharacterDirector() {
		loadSPI();
	}

	public CharacterDirector(Measurable m) {
		this.measurable = m;
	}

	public void append(char c) throws Exception {
		builder.append(c);
	}

	public CharSequence getCharSequence() { // The product is a CharSequence
		return new String(builder.getSequence()).trim().intern();
	}

	private void loadSPI() {
		ServiceLoader<Measurable> services = ServiceLoader.load(Measurable.class);
		Measurable m = services.iterator().next();
		if (m != null)
			this.measurable = m;

		for (Measurable me : services) {
			System.out.println(me.getClass().getName());
		}
	}

	@Override
	public float getDistance(CharSequence s, CharSequence t) throws Exception {
		return measurable.getDistance(s, t);
	}

	@Override
	public float compare(CharSequence s, CharSequence t) throws Exception {
		return FuzzyMeasurable.super.compare(s, t);
		// return NormalizedMeasurable.super.compare(s, t);
	}
}
