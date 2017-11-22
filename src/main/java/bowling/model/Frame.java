package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);
	int tryNo = 1;
	
	abstract public String getStatus();
	
	public int getTryNo() {
		return tryNo;
	}
	
	abstract public void play(int pin);
	//왜 구지 static? 
	static boolean isSpare(int previousPin, int pin) {
		return previousPin + pin == 10;
	}

	static boolean isMiss(int previousPin, int pin) {
		return previousPin + pin < 10;
	}
	
	static boolean isStrike(int pin) {
		return pin == 10;
	}

	String makeSpare(int pin) {
		 return makeStatus(pin) + "|/";
	}

	String makeMiss(int previousPin, int pin) {
		return makeStatus(previousPin) + "|" + makeStatus(pin);
	}
	
	void addTryNo() {
		tryNo++;
	}

	String makeStatus(int pin) {
		if (isStrike(pin)) {
			return "X";
		}
		return pinToStatus(pin);
	}
	
	String pinToStatus(int pin) {
		if (pin == 0) {
			return "-";
		}
		return String.valueOf(pin);
	}
	
	String makeStatus(int previousPin, int pin) {
		if(isSpare(previousPin, pin)) {
			return makeSpare(previousPin);
		}
		return makeMiss(previousPin, pin);
	}
	
	boolean isNotBlank(int pin) {
		return pin == 0;
	}
	
	abstract boolean isEnd();
}