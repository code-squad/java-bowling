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

	public void setScore(String knockedPins) {
		checkRound();
		if (isEndFrame()) {
			nextFrame.setScore(knockedPins);
			return;
		}
		score.setScore(knockedPins);
	}

	private void checkRound() {
		if (round == 2) {
			endFrame = true;
		}
		round++;
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
