package domain.pin;

import domain.status.Status;

import java.util.*;
import java.util.stream.Stream;

public class Pins {
	private List<Pin> pins;
	
	public Pins(int pin) {
		pins = new ArrayList<>(Arrays.asList(new Pin(pin)));
	}
	
	public Pins add(int pin) {
		if(getLastStatus().isClear()) {
			pins.add(new Pin(pin));
			return this;
		}
		
		pins.add(new Pin(pin, getLastStatus().next(pin)));
		return this;
	}

	public int sum() {
		return pins.stream()
				.mapToInt(Pin::getPin)
				.sum();
	}

    public int size() {
		return pins.size();
    }
    
    public Pin getLast() {
		return pins.get(pins.size() - 1);
    }
    
    public Status getLastStatus() {
		return getLast().getStatus();
    }
	
	public Stream<Pin> stream() {
		return pins.stream();
	}
	
	public Pin getFirst() {
		return pins.get(0);
	}
}
