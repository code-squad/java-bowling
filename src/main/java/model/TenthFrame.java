package model;

import java.util.List;

public class TenthFrame extends Frame {
	public TenthFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public String decideStatus() {
		return Status.createStatusFor10thFrame(this.pins.stream().mapToInt(s -> s).toArray());
	}

	@Override
	public Frame addAfterDecide(int falledPin) {
		this.addPins(falledPin);
		if (this.isEnd()) {// 10 프레임이 끝나면,
			return new TenthFrame(this.getFrameNum() + 1);
		}
		return this;
	}

	@Override
	public boolean isEnd() {
		if (this.pins.isEmpty() || this.pins.size() == 1) {// null check
			return false;
		}
		// 1 strike
		if (Status.isStrike(this.pins.get(0))) {
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
		if (Status.isStrike(this.pins.get(1))) {
			return true;
		}
		if (this.pins.size() == 3) {
			return true;
		}
		return false;
	}

	private boolean oneMiss() {
		return this.pins.size() == 2 && !Status.isSpare(this.pins.get(0), this.pins.get(1));
	}

	private boolean oneSpareOnePin() {
		return Status.isSpare(this.pins.get(0), this.pins.get(1)) && this.pins.size() == 3;
	}

}
