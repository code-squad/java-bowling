package model;

import exception.InvalidFinFalledException;

public class Pins {
	private static final int MAX_PINS = 10;

	private int currentPins;

	private boolean isSecondBall = false;

	public Pins() {
		currentPins = MAX_PINS;
	}

	public boolean isSecondBall() {
		return isSecondBall;
	}

	public Score fallPins(int falledPins) throws InvalidFinFalledException {
		if (checkInvalidFalled() || currentPins < falledPins)
			throw new InvalidFinFalledException("넘어진 핀의 개수가 잘 못 되었습니다.");
		currentPins -= falledPins;
		Score score = new Score(falledPins, isSecondBall);
		isSecondBall = true;
		return score;
	}

	public int getScore() {
		return MAX_PINS - currentPins;
	}

	public boolean checkInvalidFalled() {
		return currentPins == 0;
	}
}