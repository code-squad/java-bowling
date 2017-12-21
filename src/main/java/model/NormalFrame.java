package model;

import Exception.HasNotValueYetException;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public Score calculateScore(Score score) throws HasNotValueYetException {// 해당 프레임의 score를 계산하는 메소드.
		if (score.isEnd()) {
			return score;
		}
		score.add(this.findPin(0).getPin());
		if (this.findPin(0).isStrike()) {// 다음 프레임이 끝났으면,
			return this.getNextFrame().calculateScore(score);
		}
		score.add(this.findPin(1).getPin());
		return calculateScore(score);
	}

	@Override
	public boolean isEnd() {
		if (this.getPins().isEmpty()) {
			return false;
		}
		if (this.getPins().size() >= 2 || this.findPin(0).isStrike()) {
			return true;
		}
		return false;
	}
}
