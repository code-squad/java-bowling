package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Pins {

	List<Integer> throwedPins = new ArrayList<>();
	List<String> marks = new ArrayList<>(); //이름 어떻게 바꾸지??
	
	public List<String> getMarks() {
		return marks;
	}
	
	public void addPin(int pin) {
		throwedPins.add(pin);
	}
	
	public List<String> addSpare(int pin) {
		marks.set(marks.size()-1, makeSpare());
		return marks;
	}

	public List<String> addMiss(int pin) {
		marks.set(marks.size()-1, makeMiss(pin));
		return marks;
	}
	
	public List<String> addStrike(int pin) {
		marks.set(marks.size()-1, lastMarks() + "|X");
		return marks;
	}
	
	public String lastMarks() {
		return marks.get(marks.size()-1);
	}
	
	public int lastThrowedPins() {
		//이번 턴 pin을 추가한 상태라 -2
		return throwedPins.get(throwedPins.size() - 2);
	}
	
	public boolean isSpare(int pin) {
		return lastThrowedPins() + pin == 10;
	}
	
	public boolean isMiss(int pin) {
		return lastThrowedPins() + pin < 10;
	}
	
	public List<String> noStrike(int pin) {
		marks.add(makeMark(Integer.toString(pin)));
		return marks;		
	}
	/**************
	 * Frame Class에서 쪼갠 것
	 * ********************/
	public List<String> strike(int pin) {
		marks.add("X");
		return marks;
	}

	public String makeSpare() {
		return lastMarks() + "|/";
	}
	
	public String makeMiss(int pin) {
		return lastMarks() + "|" + makeMark(Integer.toString(pin));
	}
	
	public String makeMark(String pin) {
		if ("0".equals(pin)) {
			return "-";
		}
		return pin;
	}
}
