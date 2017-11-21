package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NormalFrame extends Frame2 {
	
	private int noOne;
	private int noTwo;

	private static final Logger log = LoggerFactory.getLogger(Frames.class);
	
	public void play(int pin) {
		if(tryNo == 1) {
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}
	
	private void quit() {
		hasNext = false;
	}
	
	private void tryOne(int pin) {
		noOne = pin;
		addTryNo();//스트라이크면 tryNO를 높히지 말까?
		if (isStrike(noOne)) {
			status = "X";
			quit();
			return;
		} 
		status = makeStatus(noOne);
	}
	
	private void tryTwo(int pin) {
		noTwo = pin;
		quit();
		if(isStrike(noOne)) {
			return;
		}
		if (isSpare(noOne, noTwo)) {
			addSpare();
			return;
		}
		addMiss(pin);
	}

}