package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenFrame extends Frame {

	private int noOne = -1;
	private int noTwo = -1;
	private int noThree = -1;
	
	private static final Logger log = LoggerFactory.getLogger(TenFrame.class);
	
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
		noOne = pin;
	}
	
	private void tryTwo(int pin) {
		addTryNo();
		noTwo = pin;
	}
	
	private void tryThree(int pin) {
		noThree = pin;
	}
	
	private boolean isNotBlank(int no) {
		return no >= 0;
	}
	
	boolean isEnd() {
		if(isNotBlank(noTwo) && !isNotBlank(noThree)) {
			return noOne + noTwo < 10;
		} else if (isNotBlank(noThree)) {
			return true;
		}
		return false;
	}
	
	private String addStatus(String status) {
		if(isStrike(noOne) && isSpare(noTwo, noThree)) {
			return status + "|/";
		}
		return status + "|" + makeStatus(noThree);
	}
	
	public String getStatus() {
		if(isNotBlank(noTwo) && !isNotBlank(noThree)) {
			return makeStatus(noOne, noTwo);
		} else if(isNotBlank(noThree)) {
			return addStatus(makeStatus(noOne, noTwo));
		} 
		return makeStatus(noOne);
	}
}