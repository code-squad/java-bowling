package model;

import java.util.ArrayList;
import java.util.List;

public class FrameScoreBoard {

	private List<Score> scores = new ArrayList<Score>();
	private int currentIndex = -1;
	private int bonusScore = 0;

	public void addScore(Score score) {
		scores.add(score);
		currentIndex++;
	}

	public void addBonusScore(int bonusScore) {
		this.bonusScore += bonusScore;
	}

	public String currentScoreValue() {
		String currentScoreValue = "";
		for (int index = 0; index < scores.size(); index++) {
			currentScoreValue += getScoreValue(index) + "|";
		}
		int length = currentScoreValue.length();
		if(currentScoreValue.length() > 1)
			length--;
		currentScoreValue = currentScoreValue.substring(0, length);
		return currentScoreValue;
	}

	public int getSumScore() {
		return scores.stream().mapToInt(Score::getScore).sum() + bonusScore;
	}

	public String getCurrentScoreValue() {
		if (currentIndex < 0) {
			return " ";
		}
		return getScoreValue(currentIndex);
	}

	private String getScoreValue(int index) {
		if (isSecondBall(index))
			return secondScoreValue(index);
		return firstScoreValue(index);
	}

	private String firstScoreValue(int index) {
		if (get(index) == 10)
			return "X";
		return scoreValue(index);
	}

	private String secondScoreValue(int index) {
		if (get(index) + get(index - 1) == 10)
			return "/";
		return scoreValue(index);
	}

	private String scoreValue(int index) {
		if (get(index) == 0)
			return "-";
		return Integer.toString(get(index));
	}

	private int get(int index) {
		return scores.get(index).getScore();
	}

	private boolean isSecondBall(int index) {
		return scores.get(index).isNextBall();
	}
}
