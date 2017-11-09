package model;

import exception.InvalidFrameScoreException;

public class NormalFrame extends Frame {
	
	private Pins pins;
	
	public NormalFrame() {
		pins = new Pins();
	}
	
	public void firstShot(int falledPins){
		pins.fallPins(falledPins);
		firstScore = falledPins;
		shotCount++;
	}

	@Override
	protected void secondShot(int falledPins) throws InvalidFrameScoreException {
		if (shotCount != 1)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		pins.fallPins(falledPins);
		secondScore = falledPins;
		shotCount++;
	}

	@Override
	public int totalScore() {
		return firstScore + secondScore;
	}

	@Override
	public String getCurrentScoreBoard() {
		String currentScoreBoard = "";
		if (shotCount >= 1)
			currentScoreBoard += getFirstValue();
		if (shotCount == 2) {
			currentScoreBoard += "|";
			currentScoreBoard += getSecondValue();
		}
		return currentScoreBoard;
	}
}
