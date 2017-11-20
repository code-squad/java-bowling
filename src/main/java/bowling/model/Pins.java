package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Pins {

	List<Integer> throwedPins = new ArrayList<>();
	List<String> status = new ArrayList<>();
	
	public List<String> getStatus() {
		return status;
	}
	
	public void addPin(int pin) {
		throwedPins.add(pin);
	}
	
	public List<String> addSpare(int pin) {
		status.set(status.size()-1, makeSpare());
		return status;
	}

	public List<String> addMiss(int pin) {
		status.set(status.size()-1, makeMiss(pin));
		return status;
	}
	
	public List<String> addStrike(int pin) {
		status.set(status.size()-1, lastStatus() + "|X");
		return status;
	}
	
	public String lastStatus() {
		return status.get(status.size()-1);
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
		status.add(zeroToDash(Integer.toString(pin)));
		return status;		
	}

	public List<String> strike(int pin) {
		status.add("X");
		return status;
	}

	private String makeSpare() {
		return lastStatus() + "|/";
	}
	
	private String makeMiss(int pin) {
		return lastStatus() + "|" + zeroToDash(Integer.toString(pin));
	}
	
	private String zeroToDash(String pin) {
		if ("0".equals(pin)) {
			return "-";
		}
		return pin;
	}
	
	public String firstStatusOfThisFrame() {
		return lastStatus().substring(0,1);
	}
}
