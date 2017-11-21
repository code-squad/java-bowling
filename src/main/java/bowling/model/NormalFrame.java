package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NormalFrame extends Frame {

	private int noOne = -1;
	private int noTwo = -1;

	public void play(int pin) {
		if (tryNo == 1) {
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}

	@Override
	public String toString() {
		return "NormalFrame [noOne=" + noOne + ", noTwo=" + noTwo + "]";
	}

	private void tryOne(int pin) {
		noOne = pin;
		if (!isStrike(noOne)) {
			addTryNo();
		}
	}

	private void tryTwo(int pin) {
		noTwo = pin;
	}

	public String getStatus() {
		if (!isNotBlank(noTwo)) {
			return makeStatus(noOne);
		}
		return makeStatus(noOne, noTwo);
	}

	private boolean isNotBlank(int no) {
		return no >= 0;
	}

	boolean isEnd() {
		if (isStrike(noOne) || (isNotBlank(noOne) && isNotBlank(noTwo))) {
			return true;
		}
		return false;
	}
}