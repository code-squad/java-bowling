package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenFrame extends Frame2 {

	private int noOne;
	private int noTwo;
//	private int noThree; //아직 안 씀
	
	private static final Logger log = LoggerFactory.getLogger(TenFrame.class);

	
	public String getStatus() {
		return status;
	}
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
		noOne = pin;
		addTryNo();
		if (isStrike(noOne)) {
			status = "X";
			return;
		} 
		status = makeStatus(noOne);
	}
	
	private void tryTwo(int pin) {
		addTryNo();
		noTwo = pin;
		if(isStrike(noOne) && isStrike(noTwo)) {
			addStrike();
			return;
		} else if (!isStrike(noOne) && isSpare(noOne, noTwo)) {
			addSpare();
			return;
		} else if (!isStrike(noOne) && isMiss(noOne,noTwo)) {
			quit();
		} 
		addMiss(pin);
	}
	
	private void quit() {
		tryNo = 4;
	}
	
	private void tryThree(int pin) {
		quit();
		if (isStrike(pin)) {
			addStrike();
			return;
		} else if(isStrike(noOne) && isSpare(noTwo, pin)) {
			addSpare();
			return;
		}
		addMiss(pin);
	}

	
	private void addStrike() {
		status += "|X";
	}
	
	public boolean hasNext() {
		return tryNo < 4;
	}
	

}