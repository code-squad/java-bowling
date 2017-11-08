package model;

import Exception.FrameScoreException;

public class TenFrameScore extends FrameScore {
	private int lastScore = 0;

	@Override
	public void shot(int score) {
		if (shotCount > 3)
			throw new FrameScoreException("점수 입력을 초과하였습니다.");
		if (shotCount == 2)
			lastShot(score);
		if (shotCount == 1)
			secondShot(score);
		if (shotCount == 0)
			firstShot(score);

	}

	@Override
	public void secondShot(int score) {
		if (!(shotCount == 1))
			throw new FrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		if (!(firstScore == 10) && firstScore + score > 10)
			throw new FrameScoreException("불가능한 점수 입니다.");
		secondScore = score;
		shotCount++;
	}

	@Override
	public int totalScore() {
		return firstScore + secondScore + lastScore;
	}

	public void lastShot(int score) throws FrameScoreException {
		if (!(shotCount == 2))
			throw new FrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		if (!isLastShot())
			throw new FrameScoreException("불가능한 점수 입니다.");
		if (!(isLastShotNewPins()) && firstScore == 10 && secondScore + score > 10)
			throw new FrameScoreException("불가능한 점수 입니다.");
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
		if (secondScore == 10)
			return true;
		if (firstScore + secondScore == 10)
			return true;
		return false;
	}

	public String getLastString() {
		if (!isLastShotNewPins())
			return nomalShotString(secondScore, lastScore);
		return nomalShotString(lastScore);
	}

	@Override
	public String getCurrentScoreBoard() {
		String currentScoreBoard = "";
		if (shotCount >= 1)
			currentScoreBoard += getFirstString();
		if (shotCount >= 2) {
			currentScoreBoard += "|";
			currentScoreBoard += getSecondString();
		}
		if (shotCount == 3) {
			currentScoreBoard += "|";
			currentScoreBoard += getLastString();
		}
		return currentScoreBoard;
	}
}
