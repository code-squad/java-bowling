package bowling.model;

import java.util.List;

public class Score {
	private int score;
	private String knockedPins;
	private String sumScore;

	public Score() {
		knockedPins = null;
	}

	public void setScore(String knockedPins) {
		this.knockedPins = makeStrScore(knockedPins);
	}

	private String makeStrScore(String knockedPins) {
		if (knockedPins.equals("10")) {
			score = 10;
			return "X";
		}
		return calStrScore(knockedPins);
	}

	private String calStrScore(String knockedPins) {
		String[] strArr = knockedPins.split("|");
		score = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
		if (score == 10) {
			return strArr[0] + "|/";
		}
		return knockedPins;
	}

	public boolean isNotSetting() {
		return knockedPins == null;
	}

	public int getScore() {
		return score;
	}

	public String getKnockedPins() {
		return knockedPins;
	}

	public void getKnockedPins(List<String> knockedPins, List<Integer> intScores) {
		if (!isNotSetting()) {
			knockedPins.add(this.knockedPins);
			intScores.add(this.score);
			return;
		}
		knockedPins.add(" ");
	}
}
