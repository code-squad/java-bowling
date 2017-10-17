package bowling.model;

import java.util.List;

public class Frame {
	private Frame nextFrame;
	private Score score;
	private int round;
	private boolean isStrike;
	private boolean endFrame;

	public Frame() {
		score = new Score();
		round = 1;
		isStrike = false;
		endFrame = false;
	}

	public int size() {
		if (nextFrame == null) {
			return 1;
		}
		return 1 + nextFrame.size();
	}

	public void addFrame(Frame frame) {
		if (nextFrame == null) {
			nextFrame = frame;
			return;
		}
		nextFrame.addFrame(frame);
	}

	public int setScore(String knockedPins) {
		if (isEndFrame() | isStrike()) {
			return nextFrame.setScore(knockedPins);
		}
		score.setScore(knockedPins);
		checkStrike(knockedPins);
		return checkEndFrame();
	}

	private void checkStrike(String knockedPins) {
		if (knockedPins.equals("10")) {
			isStrike = true;
		}
	}

	private boolean isStrike() {
		return isStrike;
	}

	private int checkEndFrame() {
		if (round == 2 || isStrike()) {
			endThisFrame();
			return 1;
		}
		round++;
		return 0;
	}

	private void endThisFrame() {
		endFrame = true;
	}

	private boolean isEndFrame() {
		return endFrame;
	}

	public int getSumScore() {
		if (score.isNotSetting()) {
			return 0;
		}
		return score.getScore() + nextFrame.getSumScore();
	}

	public void getKnockedPins(List<String> knockedPins, List<Integer> intScores) {
		score.getKnockedPins(knockedPins, intScores);
		if (nextFrame != null) {
			nextFrame.getKnockedPins(knockedPins, intScores);
		}
	}
}
