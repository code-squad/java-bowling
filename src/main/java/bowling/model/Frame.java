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
	static boolean isSpare(int lastPin, int pin) {
		return lastPin + pin == 10;
	}

	static boolean isMiss(int lastPin, int pin) {
		return lastPin + pin < 10;
	}
	
	static boolean isStrike(int pin) {
		return pin == 10;
	}

	String makeSpare(int pin) {
		 return makeStatus(pin) + "|/";
	}
	//리뷰: 변수명 무슨 뜻인지 모르겠음
	String makeMiss(int lastPin, int pin) {
		return makeStatus(lastPin) + "|" + makeStatus(pin);
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
	
	String makeStatus(int lastPin, int pin) {
		if(isSpare(lastPin, pin)) {
			return makeSpare(lastPin);
		}
		return makeMiss(lastPin, pin);
	}
	
	boolean isNotBlank(int pin) {
		return pin == 0;
	}
	
	abstract boolean isEnd();
}