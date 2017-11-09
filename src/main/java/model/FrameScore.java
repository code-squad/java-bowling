package model;

import exception.InvalidFrameScoreException;

public abstract class FrameScore {
	protected int firstScore = 0;
	protected int secondScore = 0;
	protected int shotCount = 0;
	
	public void shot(int score) {
		if (score > 10)
			throw new InvalidFrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (shotCount > 1)
			throw new InvalidFrameScoreException("점수 입력을 초과하였습니다.");
		if (shotCount == 1)
			secondShot(score);
		if (shotCount == 0)
			firstShot(score);

	}

	protected void firstShot(int score) throws InvalidFrameScoreException {
		firstScore = score;
		shotCount++;
	}

	protected abstract void secondShot(int score);

	public abstract int totalScore();

	protected String scoretValue(int score) {
		String scoreString = Integer.toString(score);
		if (score == 10)
			scoreString = "X";
		if (score == 0)
			scoreString = "-";
		return scoreString;
	}

	protected String scoreValue(int previousScore, int currentScore) {
		String scoreValue = scoretValue(currentScore);
		if (previousScore + currentScore == 10)
			scoreValue = "/";
		return scoreValue;
	}

	protected String getFirstValue() {
		return scoretValue(firstScore);
	}

	protected String getSecondValue() {
		if (firstScore + secondScore == 10)
			return "/";
		if (firstScore == 10)
			return scoretValue(secondScore);
		return scoreValue(firstScore, secondScore);
	}

	protected int getShotCount() {
		return shotCount;
	}

	public abstract String getCurrentScoreBoard();
}
