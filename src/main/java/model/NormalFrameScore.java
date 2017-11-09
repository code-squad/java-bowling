package model;

import exception.InvalidFrameScoreException;

public class NormalFrameScore extends FrameScore {

	@Override
	protected void secondShot(int score) throws InvalidFrameScoreException {
		if (firstScore == 10)
			throw new InvalidFrameScoreException("불가능한 점수 입력입니다.");
		if (firstScore + score > 10)
			throw new InvalidFrameScoreException("불가능한 점수 입니다. (10점 초과)");
		if (shotCount != 1)
			throw new InvalidFrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
		secondScore = score;
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
