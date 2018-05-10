package domain.pin;

import java.util.*;

public class Pins {
	public static final int DEFAULT_START_PIN_COUNT = 10;
	
	private List<Pin> pins;
	
	public Pins(int pin) {
		pins = new ArrayList<>(Arrays.asList(new Pin(pin)));
	}
	
	public void add(int pin) {
		pins.add(new Pin(pin));
	}

	public int sum() {
		return pins.stream()
				.mapToInt(Pin::getPin)
				.sum();
	}

    public int size() {
		return pins.size();
    }
}
