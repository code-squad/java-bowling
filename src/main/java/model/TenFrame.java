package model;

import exception.InvalidFrameScoreException;

public class TenFrame extends Frame {

	private int lastScore = 0;
	private Pins pins;
	private boolean isLastShot = false;

	public TenFrame() {
		pins = new Pins();
	}

	private void checkSetPinsAndShotCount() {
		shotCount++;
		if (pins.checkInvalidFalled()) {
			pins = new Pins();
			isLastShot = true;
		}
	}

	@Override
	protected void firstShot(int falledPins) {
		pins.fallPins(falledPins);
		firstScore = falledPins;
		checkSetPinsAndShotCount();
	}

	@Override
	public void shot(int score) {
		if (shotCount > 3)
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
		if (shotCount == 2)
			lastShot(score);
		if (shotCount == 1)
			secondShot(score);
		if (shotCount == 0)
			firstShot(score);
	}

	@Override
	protected void secondShot(int falledPins) {
		if (shotCount != 1)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		pins.fallPins(falledPins);
		secondScore = falledPins;
		checkSetPinsAndShotCount();
	}

	@Override
	public int totalScore() {
		return firstScore + secondScore + lastScore;
	}

	protected void lastShot(int falledPins) throws InvalidFrameScoreException {
		if (shotCount != 2)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		if (!isLastShot)
			throw new InvalidFrameScoreException("3번째 투구를 할 수 없습니다.");
		pins.fallPins(falledPins);
		lastScore = falledPins;
		shotCount++;
	}

	private boolean isLastShotNewPins() {
		if (secondScore == 10 || firstScore + secondScore == 10)
			return true;
		return false;
	}

	protected String getLastValue() {
		if (!isLastShotNewPins())
			return scoreValue(secondScore, lastScore);
		return scoreValue(lastScore);
	}

	@Override
	public String getCurrentScoreBoard() {
		String currentScoreBoard = "";
		if (shotCount < 1)
			return currentScoreBoard;
		currentScoreBoard += getFirstValue();
		if (shotCount < 2)
			return currentScoreBoard;
		currentScoreBoard += "|" + getSecondValue();
		if (shotCount < 3)
			return currentScoreBoard;
		currentScoreBoard += "|" + getLastValue();
		return currentScoreBoard;
	}
}