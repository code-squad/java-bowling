package model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}
	@Override
	public Frame addAfterDecide(Pin pin) {
		this.addPins(pin);
		if (!isEnd()) {
			return this;
		}
		if (this.getFrameNum() == 9) {
			return new TenthFrame(this.getFrameNum() + 1);
		}
		return new NormalFrame(this.getFrameNum() + 1);
	}
	
//	@Override
//	public Frame addAfterDecide(int falledPin) {
//		this.addPins(falledPin);
//		if (!isEnd()) {
//			return this;
//		}
//		if (this.getFrameNum() == 9) {
//			return new TenthFrame(this.getFrameNum() + 1);
//		}
//		return new NormalFrame(this.getFrameNum() + 1);
//	}
//
//	@Override
//	public String decideStatus() {
//		return Status.createStatusFor10thFrame(this.pins.stream().mapToInt(s -> s).toArray());
//	}

	@Override
	public boolean isEnd() {
		if (this.getPins().isEmpty()) {
			return false;
		}
		if (this.getPins().size() >= 2 || Status.isStrike(this.getPins().get(0))) {
			return true;
		}
		return false;
	}

	

}
