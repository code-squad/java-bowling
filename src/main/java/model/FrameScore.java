package model;

import Exception.FrameScoreException;

public abstract class FrameScore {
	protected int firstScore = 0;
	protected int secondScore = 0;
	protected int shotCount = 0;

	public void shot(int score) {
		if (score > 10)
			throw new FrameScoreException("점수 입력이 잘 못 되었습니다.");
		if (shotCount > 1)
			throw new FrameScoreException("점수 입력을 초과하였습니다.");
		if (shotCount == 1)
			secondShot(score);
		if (shotCount == 0)
			firstShot(score);

	}

	public void firstShot(int score) throws FrameScoreException {
		if (!(shotCount == 0))
			throw new FrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		firstScore = score;
		shotCount++;
	}

	public abstract void secondShot(int score);

	public abstract int totalScore();

	protected String nomalShotString(int score) {
		String scoreString = Integer.toString(score);
		if (score == 10)
			scoreString = "X";
		if (score == 0)
			scoreString = "-";
		return scoreString;
	}

	protected String nomalShotString(int previousScore, int currentScore) {
		String scoreString = nomalShotString(currentScore);
		if (previousScore + currentScore == 10)
			scoreString = "/";
		return scoreString;
	}

	public String getFirstString() {
		return nomalShotString(firstScore);
	}

	public String getSecondString() {
		if (firstScore + secondScore == 10)
			return "/";
		if (firstScore == 10)
			return nomalShotString(secondScore);
		return nomalShotString(firstScore, secondScore);
	}

	public int getShotCount() {
		return shotCount;
	}

	public abstract String getCurrentScoreBoard();
}
