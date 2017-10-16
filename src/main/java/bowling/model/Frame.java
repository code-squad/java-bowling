package bowling.model;

import java.util.List;

public class Frame {
	Frame nextFrame;
	Score score;

	public Frame() {
		this.score = new Score();
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
		if (score.isNotSetting()) {
			score.setScore(knockedPins);
			return;
		}
		nextFrame.setScore(knockedPins);
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
