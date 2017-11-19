package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	
	List<Integer> throwedPins = new ArrayList<>();
	List<String> marks = new ArrayList<>(); //이름 어떻게 바꾸지??
	boolean hasNext = true;
	int ballNum = 1;
	int frameNum = 1;
	//클래스 분리
	Pins pins = new Pins();

	public List<String> normal(int pin) {
		if (ballNum == 1) {
			return normalFrameOneBall2(pin);
		}
		return normalFrameTwoBall2(pin);
	}
	
	public List<String> ten(int pin) {
		if (ballNum == 1) {
			return tenFrameOneBall2(pin);
		} 
		if (ballNum == 2) {
			return tenFrameTwoBall2(pin);
		} 
		return tenFrameThreeBall2(pin);
	}
	
	public List<String> normalFrameOneBall(int pin) {
		if (pin == 10) {
			addFrame();
			return strike(pin);
		} 
		addBallNum();
		marks.add(makeMark(Integer.toString(pin)));
		throwedPins.add(pin);
		return marks;
	}
	
	public List<String> normalFrameOneBall2(int pin) {
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
		if (pin == 10) {
			return strike(pin);
		} 
		marks.add(makeMark(Integer.toString(pin)));
		throwedPins.add(pin);
		return marks;
	}
	
	public List<String> tenFrameOneBall2(int pin) {
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
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		int marksSize = marks.size() - 1;//얘를 안 만들 방법이 없을까?
		throwedPins.add(pin);//위에다 두면 lastNum이 pin값이 됨..
		if (lastNum + pin == 10) {
			marks.set(marksSize, makeSpare(marksSize));
			return marks;
		}
		marks.set(marksSize, makeMiss(pin, marksSize));
		return marks;
	}
	
	public List<String> normalFrameTwoBall2(int pin) {
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
		int marksSize = marks.size() -1;
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		throwedPins.add(pin);
		if("X".equals(marks.get(marksSize))) {
			if (pin == 10) {
				marks.set(marksSize, marks.get(marksSize) + "|X");
				return marks;
			}
			marks.set(marksSize, makeMiss(pin, marksSize));
			return marks;
		}
		if (lastNum + pin < 10) {
			quit();
			marks.set(marksSize, makeMiss(pin, marksSize));
		} else if (lastNum + pin == 10) {
			marks.set(marksSize, makeSpare(marksSize));
		}
		return marks;
	}
	
	public List<String> tenFrameTwoBall2(int pin) {
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
		int marksSize = marks.size() -1;
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		throwedPins.add(pin);
		if (pin == 10) {
			marks.set(marksSize, marks.get(marksSize) + "|X");
			return marks;
		}
		//전전이 X면
		if("X".equals(marks.get(marksSize).substring(0,1))) {
			if (lastNum + pin < 10) {
				marks.set(marksSize, makeMiss(pin, marksSize));
			} else if (lastNum + pin == 10) {
				marks.set(marksSize, makeSpare(marksSize));
			}
			return marks;
		}
		marks.set(marksSize, makeMiss(pin, marksSize));
		return marks;
	}
	
	public List<String> tenFrameThreeBall2(int pin) {
		quit();
		pins.addPin(pin);
		if (pin == 10) {
			return pins.addStrike(pin);
		}
		//전전이 X면
		if("X".equals(pins.lastMarks().substring(0,1)) && pins.isSpare(pin)) {
			return pins.addSpare(pin);
		}
		return pins.addMiss(pin);
	}
	
	public void quit() {
		hasNext = false;
	}

	public List<String> strike(int pin) {
		throwedPins.add(pin);
		marks.add("X");
		return marks;
	}

	public String makeSpare(int marksSize) {
		return marks.get(marksSize) + "|/";
	}
	
	public String makeMiss(int pin, int marksSize) {
		return marks.get(marksSize) + "|" + makeMark(Integer.toString(pin));
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

	public String makeMark(String pin) {
		if ("0".equals(pin)) {
			return "-";
		}
		return pin;
	}
	
	public boolean hasNext() {
		return hasNext;
	}
	
	public int getFrameNum() {
		return frameNum;
	}

}
