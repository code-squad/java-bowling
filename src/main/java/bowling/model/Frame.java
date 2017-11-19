package bowling.model;

import java.util.List;

public class Frame {
	
	boolean hasNext = true;
	int ballNum = 1;
	int frameNum = 1;
	//클래스 분리
	Pins pins = new Pins();

	public List<String> normal(int pin) {
		if (ballNum == 1) {
			return normalFrameOneBall(pin);
		}
		return normalFrameTwoBall(pin);
	}
	
	public List<String> ten(int pin) {
		if (ballNum == 1) {
			return tenFrameOneBall(pin);
		} 
		if (ballNum == 2) {
			return tenFrameTwoBall(pin);
		} 
		return tenFrameThreeBall(pin);
	}
	
	public List<String> normalFrameOneBall(int pin) {
		pins.addPin(pin);
		if (pin == 10) {
			addFrame();
			return pins.strike(pin);
		} 
		addBallNum();
		return pins.noStrike(pin);
	}
	
	public List<String> tenFrameOneBall(int pin) {
		addBallNum();
		pins.addPin(pin);
		if (pin == 10) {
			return pins.strike(pin);
		} 
		return pins.noStrike(pin);
	}
	
	public List<String> normalFrameTwoBall(int pin) {
		addFrame();
		subtractBallNum();
		pins.addPin(pin);
		if (pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		return pins.addMiss(pin);
	}
	
	public List<String> tenFrameTwoBall(int pin) {
		addBallNum();
		pins.addPin(pin);
		if("X".equals(pins.lastMarks()) && pin == 10) {
			return pins.addStrike(pin);
		}
		if (pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		if (pins.isMiss(pin)) {
			quit();
		}
		return pins.addMiss(pin);
	}
	
	public List<String> tenFrameThreeBall(int pin) {
		quit();
		pins.addPin(pin);
		if (pin == 10) {
			return pins.addStrike(pin);
		}
		//10프레임 1투구가 X
		if("X".equals(pins.lastMarks().substring(0,1)) && pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		return pins.addMiss(pin);
	}
	
	public void quit() {
		hasNext = false;
	}
//메소드로 만들 필요가 있을까?
	public void addFrame() {
		frameNum++;
	}

	public void addBallNum() {
		ballNum++;
	}

	public void subtractBallNum() {
		ballNum--;
	}
	
	public boolean hasNext() {
		return hasNext;
	}
	
	public int getFrameNum() {
		return frameNum;
	}
}