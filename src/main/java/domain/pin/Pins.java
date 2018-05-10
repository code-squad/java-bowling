package domain.pin;

import java.util.Arrays;
import java.util.List;

public class Pins {
	public static final int DEFAULT_START_PIN_COUNT = 10;
	
	private List<Pin> pins;
	
	public Pins(int pin) {
		pins = Arrays.asList(new Pin(pin));
	}
	
	public void add(int pin) {
		pins.add(new Pin(pin));
	}
	
}
