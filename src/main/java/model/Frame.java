package model;

import java.util.ArrayList;
import java.util.List;

import Exception.InvalidFrameNumberException;

public abstract class Frame {
	private int frameNum;
	private List<Pin> pins = new ArrayList<>();

	public Frame(int frameNum) {
		if (frameNum == 11) {
			throw new InvalidFrameNumberException();
		}
		this.frameNum = frameNum;
	}

	public int getFrameNum() {
		return frameNum;
	}

	public void addPins(Pin pin) {
		this.pins.add(pin);
	}

	public List<Pin> getPins() {
		return this.pins;
	}

	public Pin findPin(int index) {
		return this.pins.get(index);
	}

	public String decideStatus() {
		// list to array
		return Status.createStatus(this.getPins().stream().map(s -> s).toArray(Pin[]::new));
	}

	public boolean isNewFrame(Frame frame) {
		return frame != this;
	}

	public abstract boolean isEnd();

	public abstract Frame addAfterDecide(Pin pin);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frameNum;
		result = prime * result + ((pins == null) ? 0 : pins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (frameNum != other.frameNum)
			return false;
		if (pins == null) {
			if (other.pins != null)
				return false;
		} else if (!pins.equals(other.pins))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frame [frameNum=" + frameNum + ", pins=" + pins + "]";
	}

}
