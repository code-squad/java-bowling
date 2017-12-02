package model;

import java.util.List;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public Frame addAfterDecide(int falledPin) {
		this.addPins(falledPin);
		if (!isEnd()) {
			return this;
		}
		if (this.getFrameNum() == 9) {
			return new TenthFrame(this.getFrameNum() + 1);
		}
		return new NormalFrame(this.getFrameNum() + 1);
	}

	@Override
	public String decideStatus() {
		return Status.createStatusFor10thFrame(this.pins.stream().mapToInt(s -> s).toArray());
	}

	@Override
	public boolean isEnd() {
		if (this.pins.isEmpty()) {
			return false;
		}
		if (this.pins.size() >= 2 || Status.isStrike(this.pins.get(0))) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pins == null) ? 0 : pins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NormalFrame other = (NormalFrame) obj;
		if (pins == null) {
			if (other.pins != null)
				return false;
		} else if (!pins.equals(other.pins))
			return false;
		return true;
	}

}
