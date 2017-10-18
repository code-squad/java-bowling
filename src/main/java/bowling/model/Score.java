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
		this.knockedPins += makeKnockedPins(knockedPins);
	}

	private String makeKnockedPins(String knockedPins) {
		if (knockedPins.equals("10")) {
			score += 10;
			return "X ";
		}
		if (knockedPins.equals("|")) {
			return "|";
		}
		return calKnockedPins(knockedPins);
	}

	private String calKnockedPins(String knockedPins) {
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

	public void getKnockedPins(List<String> knockedPins, List<String> sumScores) {
		if (!isNotSetting()) {
			knockedPins.add(this.knockedPins);
			sumScores.add(this.sumScore);
			return;
		}
		knockedPins.add(" ");
		sumScores.add(" ");
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

	public int firstRoundScore() {
		if (knockedPins.startsWith("X")) {
			return 10;
		}
		return Integer.parseInt(knockedPins.substring(0, 1));
	}

	public int secondRoundScore() {
		if (knockedPins.startsWith("X")) {
			return 10;
		}
		if (knockedPins.startsWith("/")) {
			return 10 - firstRoundScore();
		}
		return Integer.parseInt(knockedPins.substring(1, 2));
	}

	public void calculateSpecial(int score) {
		this.sumScore = Integer.toString(Integer.parseInt(sumScore) + score);
	}
}
