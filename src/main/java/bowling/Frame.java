package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;

public abstract class Frame {
	protected ArrayList<Integer> frame = new ArrayList<>();

	public void addScore(int score) {
		frame.add(score);
	}

	public int getScopeOfScore() {
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

	public Status getStatus() {
		return Status.valueOf(getScopeOfScore(), frame.size());
	}

	public boolean isReady() {
		return getStatus() == Status.READY;
	}

	public boolean isMiss() {
		return (getStatus() == MISSORNORMAL) && frame.get(1) == 0;
	}

	public boolean isNormal() {
		return (getStatus() == MISSORNORMAL && frame.get(1) != 0);
	}

	public abstract boolean isSpare();

	public abstract boolean isStrike();

	public abstract boolean isNotEnd();

	public abstract String changeFormat();

}
