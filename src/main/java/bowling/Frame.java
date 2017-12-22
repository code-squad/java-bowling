package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;

public abstract class Frame {
	private ArrayList<Integer> frame = new ArrayList<>();

	public Frame(ArrayList<Integer> frame) {
		this.frame = frame;
	}

	protected void addScore(int score) {
		frame.add(score);
	}

	protected int getScopeOfScore() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		if (totalScore == 10)
			return 1;
		if (totalScore < 10)
			return 0;
		return -1;
	}

	protected Status getStatus() {
		return Status.valueOf(getScopeOfScore(), frame.size());
	}

	protected boolean isReady() {
		return getStatus() == Status.READY;
	}

	protected boolean isMiss() {
		return (getStatus() == MISSORNORMAL) && frame.get(1) == 0;
	}

	protected boolean isNormal() {
		return (getStatus() == MISSORNORMAL && frame.get(1) != 0);
	}

	protected String getReadyResult() {
		return "\t" + frame.get(0) + " | ";
	}

	protected String getSpareResult() {
		return "/" + "\t|";
	}

	protected String getStrikeResult() {
		return "\t" + "X" + "\t| ";
	}

	protected String getMissResult() {
		return "-" + "\t|";
	}

	protected String getNormalResult() {
		return frame.get(1) + "\t|";
	}

	protected String getStatusResult(String result) {
		if (isReady())
			return getReadyResult();

		if (isStrike()) {
			return getStrikeResult();
		}

		if (isSpare()) {
			result += getSpareResult();
			return result;
		}

		if (isMiss()) {
			result += getMissResult();
			return result;
		}
		if (isNormal()) {
			result += getNormalResult();
			return result;
		}
		return result;
	}

	protected abstract boolean isSpare();

	protected abstract boolean isStrike();

	protected abstract boolean isNotEnd();

	protected abstract String changeFormat();

}
