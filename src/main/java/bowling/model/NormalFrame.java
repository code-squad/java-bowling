package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NormalFrame extends Frame {
	private int pin1 = -1;
	private int pin2 = -1;

	public void play(int pin) {
		if (tryNo == 1) {
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}

	private void tryOne(int pin) {
		pin1 = pin;
		if (!isStrike(pin1)) {
			addTryNo();
		}
	}

	private void tryTwo(int pin) {
		pin2 = pin;
	}

	public String getStatus() {
		if (!isNotBlank(pin2)) {
			return makeStatus(pin1);
		}
		return makeStatus(pin1, pin2);
	}

	boolean isEnd() {
		if (isStrike(pin1) || (isNotBlank(pin1) && isNotBlank(pin2))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "NormalFrame [pin1=" + pin1 + ", pin2=" + pin2 + "]";
	}
}