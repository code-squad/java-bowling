package model;

import exception.InvalidFrameScoreException;

public class TenFrameScore extends FrameScore {
	private int lastScore = 0;

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
	protected void secondShot(int score) {
		if (shotCount != 1)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		if (firstScore != 10 && firstScore + score > 10)
			throw new InvalidFrameScoreException("불가능한 점수 입니다.");
		secondScore = score;
		shotCount++;
	}

	@Override
	public int totalScore() {
		return firstScore + secondScore + lastScore;
	}

	protected void lastShot(int score) throws InvalidFrameScoreException {
		if (shotCount != 2)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		if (!isLastShot())
			throw new InvalidFrameScoreException("불가능한 점수 입니다.");
		if (!(isLastShotNewPins()) && firstScore == 10 && secondScore + score > 10)
			throw new InvalidFrameScoreException("불가능한 점수 입니다.");
		lastScore = score;
		shotCount++;
	}

	private boolean isLastShot() {
		if (firstScore == 10)
			return true;
		if (firstScore + secondScore == 10)
			return true;
		return false;
	}

	private boolean isLastShotNewPins() {
		if (secondScore == 10 || firstScore + secondScore == 10)
			return true;
		return false;
	}

	protected String getLastValue() {
		if (!isLastShotNewPins())
			return scoreValue(secondScore, lastScore);
		return scoretValue(lastScore);
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
