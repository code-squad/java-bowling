package model;

public class TenthFrame extends Frame {
	public TenthFrame(int frameNum) {
		super(frameNum);
	}
	
	@Override
	public Frame addAfterDecide(Pin pin) {
		this.addPins(pin);
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
		// 1 strike
		if (Status.isStrike(this.getPins().get(0))) {
			return oneStrikeOr2Pins();
		}
		// 1spare + 1 pin
		if (oneSpareOnePin()) {
			return true;
		}
		// 1 miss
		if (oneMiss()) {
			return true;
		}
		return false;
	}


	private boolean oneStrikeOr2Pins() {
		if (Status.isStrike(this.getPins().get(1))) {
			return true;
		}
		if (this.getPins().size() == 3) {
			return true;
		}
		return false;
	}

	private boolean oneMiss() {
		return this.getPins().size() == 2 && !Status.isSpare(this.getPins().get(0), this.getPins().get(1));
	}

	private boolean oneSpareOnePin() {
		return Status.isSpare(this.getPins().get(0), this.getPins().get(1)) && this.getPins().size() == 3;
	}
}
