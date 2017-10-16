package bowling.model;

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

	public void setScore(String strScore) {
		if (score.isNotSetting()) {
			score.settingScore(strScore);
			return;
		}
		nextFrame.setScore(strScore);
	}

	public int getSumScore() {
		if (score.isNotSetting()) {
			return 0;
		}
		return score.getIntScore() + nextFrame.getSumScore();
	}
}
