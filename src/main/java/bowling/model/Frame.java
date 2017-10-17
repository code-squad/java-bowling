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

	public String getSumScore() {
		if (!nextFrame.isEndFrame()) {
			return score.getSumScore();
		}
		return nextFrame.getSumScore();
	}

	public void getKnockedPins(List<String> knockedPins, List<String> intScores) {
		score.getKnockedPins(knockedPins, intScores);
		if (isNotNextFrame()) {
			nextFrame.getKnockedPins(knockedPins, intScores);
		}
	}

	public void calculateSumScore() {
		calculateSumScore(score.calculateSumScore("first"));
	}

	private void calculateSumScore(String sumScore) {
		if (isEndFrame()) {
			score.calculateSumScore(sumScore);
		}
		if (isNotNextFrame()) {
			nextFrame.calculateSumScore(score.getSumScore());
		}
	}
	
	private boolean isNotNextFrame() {
		return nextFrame != null;
	}
}
