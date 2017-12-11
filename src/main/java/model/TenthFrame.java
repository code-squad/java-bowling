package model;

public class TenthFrame extends Frame {
	public TenthFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public String whenIsMiss() {
		int score = this.findPin(0).getPin() + this.findPin(1).getPin();
		return score + "";
	}

	@Override
	public String whenIsSpare() {
		int score = 10;
		Pin thirdPin = this.findPin(2);
		if (thirdPin == null) {
			return "";
		}
		score += thirdPin.getPin();
		return score + "";
	}

	@Override
	public String whenIsStrike() {
		int score = 10;
		Pin secondPin = this.findPin(1);
		if (secondPin == null) {
			return "";
		}
		score += secondPin.getPin();
		Pin thirdPin = this.findPin(2);
		if (thirdPin == null) {
			return "";
		}
		score += thirdPin.getPin();
		return score + "";
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
		return this.getPins().size() == 2 && this.findPin(0).getPin() + this.findPin(1).getPin() <= 10;
	}
}
