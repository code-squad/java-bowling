package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);
	int tryNo = 1;
	
	public String getStatus() {
		return null;
	}
	
	public int getTryNo() {
		return tryNo;
	}
	
	public void play(int pin) {}
	
	boolean isSpare(int lastPin, int pin) {
		return lastPin + pin == 10;
	}

	boolean isMiss(int lastPin, int pin) {
		return lastPin + pin < 10;
	}
	
	boolean isStrike(int pin) {
		return pin == 10;
	}
	
	String makeSpare(int noOne) {
		 return makeStatus(noOne) + "|/";
	}
	
	String makeMiss(int noOne, int noTwo) {
		return makeStatus(noOne) + "|" + makeStatus(noTwo);
	}
	
	void addTryNo() {
		tryNo++;
	}

	String makeStatus(int noOne) {
		if (isStrike(noOne)) {
			return "X";
		} else if (noOne == 0) {
			return "-";
		}
		return String.valueOf(noOne);
	}
	
	String makeStatus(int noOne, int noTwo) {
		if(isSpare(noOne, noTwo)) {
			return makeSpare(noOne);
		}
		return makeMiss(noOne, noTwo);
	}
	
	boolean isEnd() {
		return true;
	}
}