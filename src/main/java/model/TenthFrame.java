package model;

import Exception.HasNotValueYetException;

public class TenthFrame extends Frame {
	public TenthFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public Score calculateScore(Score score) throws HasNotValueYetException {// 해당 프레임의 score를 계산하는 메소드.
		if (score.isEnd()) {
			return score;
		}
		score.add(this.findPin(0).getPin());
		if (!score.isEnd()) {
			score.add(this.findPin(1).getPin());
		}
		return calculateScore(score);
	}

	@Override
	public boolean isEnd() {
		if (this.getPins().isEmpty() || this.getPins().size() == 1) {// null check
			return false;
		}
		if (this.getPins().size() == 3) {
			return true;
		}
		if (isOneMiss()) {
			return true;
		}
		return false;
	}

	private boolean isOneMiss() {
		return this.getPins().size() == 2 && this.findPin(0).getPin() + this.findPin(1).getPin() < 10;
	}
}
