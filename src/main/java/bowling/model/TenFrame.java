package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenFrame extends Frame {
	private static final Logger log = LoggerFactory.getLogger(TenFrame.class);
	private int pinNo1 = -1;
	private int pinNo2 = -1;
	private int pinNo3 = -1;
	
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
		pinNo1 = pin;
	}
	
	private void tryTwo(int pin) {
		addTryNo();
		pinNo2 = pin;
	}
	
	private void tryThree(int pin) {
		pinNo3 = pin;
	}
	
	boolean isEnd() {
		if(isNotBlank(pinNo2) && !isNotBlank(pinNo3)) {
			return pinNo1 + pinNo2 < 10;
		} else if (isNotBlank(pinNo3)) {
			return true;
		}
		return false;
	}
	
	private String addStatus(String status) {
		if(isStrike(pinNo1) && isSpare(pinNo2, pinNo3)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(pinNo3);
	}
	
	public String getStatus() {
		if(isNotBlank(pinNo2) && !isNotBlank(pinNo3)) {
			return makeStatus(pinNo1, pinNo2);
		} else if(isNotBlank(pinNo3)) {
			return addStatus(makeStatus(pinNo1, pinNo2));
		} 
		return makeStatus(pinNo1);
	}
}