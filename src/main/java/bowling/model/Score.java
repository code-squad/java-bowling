package bowling.model;

import java.util.List;

public class Score {
	private int score;
	private String knockedPins;
	private String sumScore;

	public Score() {
		knockedPins = "";
		score = 0;
		sumScore = "   ";
	}

	public void setScore(String knockedPins) {
		this.knockedPins += makeStrScore(knockedPins);
	}

	private String makeStrScore(String knockedPins) {
		if (knockedPins.equals("10")) {
			score = 10;
			return "X ";
		}
		if (knockedPins.equals("|")) {
			return "|";
		}
		return calStrScore(knockedPins);
	}

	private String calStrScore(String knockedPins) {
		score += Integer.parseInt(knockedPins);
		if (score == 10) {
			return "/";
		}
		return knockedPins;
	}

	public boolean isNotSetting() {
		return knockedPins.equals("");
	}

	public int getScore() {
		return score;
	}

	public String getKnockedPins() {
		return knockedPins;
	}

	public void getKnockedPins(List<String> knockedPins, List<String> intScores) {
		if (!isNotSetting()) {
			knockedPins.add(this.knockedPins);
			intScores.add(this.sumScore);
			return;
		}
		knockedPins.add(" ");
		intScores.add(" ");
	}

	public String getSumScore() {
		return sumScore;
	}

	public String calculateSumScore(String sumScore) {
		if (sumScore.equals("first")) {
			return firstSumScore(sumScore);
		}
		if (this.sumScore.equals("   ")) {
			return normalSumScore(sumScore);
		}
		return sumScore;
	}

	private String firstSumScore(String sumScore) {
		this.sumScore = Integer.toString(score);
		return this.sumScore;
	}

	private String normalSumScore(String sumScore) {
		int tempScore = score + Integer.parseInt(sumScore);
		this.sumScore = Integer.toString(tempScore);
		return sumScore;
	}

}
