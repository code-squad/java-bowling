package model;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public Frame addAfterDecide(Pin pin) {
		super.addPins(pin);
		if (!isEnd()) {
			return this;
		}
		if (this.getFrameNum() == 9) {
			return new TenthFrame(this.getFrameNum() + 1);
		}
		return new NormalFrame(this.getFrameNum() + 1);
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
