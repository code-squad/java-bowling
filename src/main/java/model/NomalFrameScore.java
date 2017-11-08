package model;

import Exception.FrameScoreException;

public class NomalFrameScore extends FrameScore {

	@Override
	public void secondShot(int score) throws FrameScoreException {
		if (firstScore == 10)
			throw new FrameScoreException("불가능한 점수 입력입니다.");
		if (firstScore + score > 10)
			throw new FrameScoreException("불가능한 점수 입니다. (10점 초과)");
		if (!(shotCount == 1))
			throw new FrameScoreException("점수 입력 순서가 잘 못 되었습니다.");
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
			currentScoreBoard += getFirstString();
		if (shotCount == 2) {
			currentScoreBoard += "|";
			currentScoreBoard += getSecondString();
		}
		return currentScoreBoard;
	}
}
