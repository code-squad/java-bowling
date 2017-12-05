package model;

import Exception.InvalidFrameNumberException;

public class TenthFrame extends Frame {
	public TenthFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public Frame addAfterDecide(Pin pin) throws InvalidFrameNumberException {
		super.addPins(pin);
		if (this.isEnd()) {// 10 프레임이 끝나면,
			return new TenthFrame(this.getFrameNum() + 1);
		}
		return this;
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
		return this.getPins().size() == 2 && this.findPin(0).isSpare(this.findPin(1));
	}
}
