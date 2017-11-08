package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	List<Integer> frameScore;

	public Frame() {
		frameScore = new ArrayList<Integer>();
	}

	protected int totalScore() {
		return frameScore.stream().mapToInt(Integer::intValue).sum();
	}

	public String getCurrentScoreBoard() {
		String currentScoreBoard = "";
		for (int i = 0; i < frameScore.size(); i++) {
			currentScoreBoard += scoreToString(frameScore.get(i), i);
			currentScoreBoard += "|";
		}
		return currentScoreBoard.substring(0, currentScoreBoard.length() - 1);
	}

	protected String scoreToString(int score, int index) {
		String scoreString = Integer.toString(score);
		if (score == 0)
			scoreString = "-";
		if (score == 10)
			scoreString = "X";
		if (index == 1 && totalScore() == 10)
			scoreString = "/";

		return scoreString;
	}

	abstract void shot(int score);

	abstract boolean isGetScore(Integer score);
}