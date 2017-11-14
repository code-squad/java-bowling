package model;

import java.util.ArrayList;
import java.util.List;

public class FrameScoreBoard {
	private List<Score> scores = new ArrayList<Score>();

	private int currentIndex = -1;

	public void addScore(Score score) {
		scores.add(score);
		currentIndex++;
	}

	public String currentScoreValue() {
		String currentScoreValue = "";
		for (int index = 0; index < scores.size(); index++) {
			currentScoreValue += getScoreValue(index);
			currentScoreValue += "|";
		}
		return currentScoreValue.substring(0, currentScoreValue.length() - 1);
	}

	public int getSumScore() {
		return scores.stream().mapToInt(Score::getScore).sum();
	}

	public String getCurrentScoreValue() {
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
		return scores.get(index).isSecondBall();
	}
}
