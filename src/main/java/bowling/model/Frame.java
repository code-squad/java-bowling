package bowling.model;

import java.util.List;

public class Frame {
	
	private boolean hasNext = true;
	private int tryNo = 1;
	private int frameNo = 1;
	Pins pins = new Pins();
	
	public List<String> play(int pin) {
		if(getFrameNo() < 10) {
			return bowlNormal(pin);
		}
		return bowlTen(pin);
	}
	
	private List<String> bowlNormal(int pin) {
		if (tryNo == 1) {
			return normalFrameOneBall(pin);
		}
		return normalFrameTwoBall(pin);
	}
	
	private List<String> bowlTen(int pin) {
		if (tryNo == 1) {
			return tenFrameOneBall(pin);
		} else if (tryNo == 2) {
			return tenFrameTwoBall(pin);
		} 
		return tenFrameThreeBall(pin);
	}
	
	private List<String> normalFrameOneBall(int pin) {
		pins.addPin(pin);
		if (pin == 10) {
			addFrame();
			return pins.strike(pin);
		} 
		addBallNum();
		return pins.noStrike(pin);
	}
	
	private List<String> tenFrameOneBall(int pin) {
		addBallNum();
		pins.addPin(pin);
		if (pin == 10) {
			return pins.strike(pin);
		} 
		return pins.noStrike(pin);
	}
	
	private List<String> normalFrameTwoBall(int pin) {
		addFrame();
		subtractBallNum();
		pins.addPin(pin);
		if (pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		return pins.addMiss(pin);
	}
	
	private List<String> tenFrameTwoBall(int pin) {
		addBallNum();
		pins.addPin(pin);
		if(pins.lastThrowedPins() + pin == 20) {
			return pins.addStrike(pin);
		} else if (pins.isSpare(pin)) {
			return pins.addSpare(pin);
		} else if (pins.isMiss(pin)) {
			quit();
		}
		return pins.addMiss(pin);
	}
	
	private List<String> tenFrameThreeBall(int pin) {
		quit();
		pins.addPin(pin);
		if (pin == 10) {
			return pins.addStrike(pin);
		} else if("X".equals(pins.firstStatusOfThisFrame()) && pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		return pins.addMiss(pin);
	}
	
	private void quit() {
		hasNext = false;
	}

	private void addFrame() {
		frameNo++;
	}

	private void addBallNum() {
		tryNo++;
	}

	private void subtractBallNum() {
		tryNo--;
	}
	
	public boolean hasNext() {
		return hasNext;
	}
	
	public int getFrameNo() {
		return frameNo;
	}
}