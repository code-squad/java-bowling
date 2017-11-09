package model;

import exception.InvalidFrameScoreException;

public abstract class Frame {
	
	int firstScore = 0;
	int secondScore = 0;
	int shotCount = 0;

	public abstract String getCurrentScoreBoard();

	public abstract int totalScore();

	public void shot(int score) throws InvalidFrameScoreException {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (shotCount > 1)
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
		if (shotCount == 1)
			secondShot(score);
		if (shotCount == 0)
			firstShot(score);
	}

	protected abstract void firstShot(int falledPins);

	protected abstract void secondShot(int falledPins);

	protected String scoreValue(int score) {
		String scoreString = Integer.toString(score);
		if (score == 10)
			scoreString = "X";
		if (score == 0)
			scoreString = "-";
		return scoreString;
	}

	protected String scoreValue(int previousScore, int currentScore) {
		String scoreValue = scoreValue(currentScore);
		if (previousScore + currentScore == 10)
			scoreValue = "/";
		return scoreValue;
	}

	protected String getFirstValue() {
		return scoreValue(firstScore);
	}

	protected String getSecondValue() {
		if (firstScore + secondScore == 10)
			return "/";
		if (firstScore == 10)
			return scoreValue(secondScore);
		return scoreValue(firstScore, secondScore);
	}

	protected int getShotCount() {
		return shotCount;
	}
}