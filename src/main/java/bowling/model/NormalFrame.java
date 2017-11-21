package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NormalFrame extends Frame {
	private int pinNo1 = -1;
	private int pinNo2 = -1;

	public void play(int pin) {
		if (tryNo == 1) {
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}

	private void tryOne(int pin) {
		pinNo1 = pin;
		if (!isStrike(pinNo1)) {
			addTryNo();
		}
	}

	private void tryTwo(int pin) {
		pinNo2 = pin;
	}

	public String getStatus() {
		if (!isNotBlank(pinNo2)) {
			return makeStatus(pinNo1);
		}
		return makeStatus(pinNo1, pinNo2);
	}

	boolean isEnd() {
		if (isStrike(pinNo1) || (isNotBlank(pinNo1) && isNotBlank(pinNo2))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "NormalFrame [pinNo1=" + pinNo1 + ", pinNo2=" + pinNo2 + "]";
	}
}