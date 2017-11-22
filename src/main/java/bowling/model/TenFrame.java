package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenFrame extends Frame {
	private static final Logger log = LoggerFactory.getLogger(TenFrame.class);
	private int pin1 = -1;
	private int pin2 = -1;
	private int pin3 = -1;
	
	public void play(int pin) {
		if (tryNo == 1) {
			tryOne(pin);
			return;
		} else if (tryNo == 2) {
			tryTwo(pin);
			return;
		} 
		tryThree(pin);
	}
	
	private void tryOne(int pin) {
		addTryNo();
		pin1 = pin;
	}
	
	private void tryTwo(int pin) {
		addTryNo();
		pin2 = pin;
	}
	
	private void tryThree(int pin) {
		pin3 = pin;
	}
	
	boolean isEnd() {
		if(isNotBlank(pin2) && !isNotBlank(pin3)) {
			return pin1 + pin2 < 10;
		} else if (isNotBlank(pin3)) {
			return true;
		}
		return false;
	}
	
	private String addStatus(String status) {
		if(isStrike(pin1) && isSpare(pin2, pin3)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(pin3);
	}
	
	public String getStatus() {
		if(isNotBlank(pin2) && !isNotBlank(pin3)) {
			return makeStatus(pin1, pin2);
		} else if(isNotBlank(pin3)) {
			return addStatus(makeStatus(pin1, pin2));
		} 
		return makeStatus(pin1);
	}
}