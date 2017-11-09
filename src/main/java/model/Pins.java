package model;

import exception.InvalidFinFalledException;

public class Pins {
	private static final int MAX_PINS = 10;

	private int currentPins;

	public Pins() {
		currentPins = MAX_PINS;
	}

	public void fallPins(int falledPins) throws InvalidFinFalledException {
		if (checkInvalidFalled() || currentPins < falledPins)
			throw new InvalidFinFalledException("넘어진 핀의 개수가 잘 못 되었습니다.");
		currentPins -= falledPins;
	}
	
	public int getScore() {
		return MAX_PINS - currentPins;
	}

	public boolean checkInvalidFalled() {
		if (currentPins == 0) {
			return true;
		}
		return false;
	}
}