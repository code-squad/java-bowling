package model;

import java.util.ArrayList;
import java.util.List;

import Exception.HasNotNextFrameYetException;
import Exception.InvalidFrameNumberException;

public abstract class Frame {
	private int frameNum;
	private List<Pin> pins = new ArrayList<>();
	private Frame nextFrame;

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
		if (hasNoPins() || hasOnlyOnePin(index) || hasOnlyTwoPins(index)) {
			return null;
		}
		return this.pins.get(index);
	}

	private boolean hasNoPins() {
		return this.pins.isEmpty();
	}

	private boolean hasOnlyOnePin(int index) {
		return this.pins.size() == 1 && index == 1;
	}

	private boolean hasOnlyTwoPins(int index) {
		return this.pins.size() == 2 && index == 2;
	}

	public Frame addAfterDecide(Pin pin) throws InvalidFrameNumberException {
		this.addPins(pin);
		if (!this.isEnd()) {
			return this;
		}
		if (this.getFrameNum() >= 9) {
			Frame frame = new TenthFrame(this.getFrameNum() + 1);
			this.nextFrame = frame;
			return this.nextFrame;
		}
		this.nextFrame = new NormalFrame(this.getFrameNum() + 1);
		return this.nextFrame;
	}

	public Frame getNextFrame() throws HasNotNextFrameYetException {
		if (this.nextFrame == null) {
			throw new HasNotNextFrameYetException();
		}
		return this.nextFrame;
	}

	public String createScore() {
		if (this.isEnd()) {
			if (this.findPin(0).isStrike()) {
				return this.whenIsStrike();
			}
			if (this.findPin(0).isSpare(this.findPin(1))) {// 스페어 일때.
				return this.whenIsSpare();
			}
			return this.whenIsMiss();
		}
		return "";
	}

	public String decideStatus() {
		// list to array
		return Status.createStatus(this.getPins().stream().map(s -> s).toArray(Pin[]::new));
	}

	public boolean isNewFrame(Frame frame) {
		return frame != this;
	}

	public abstract boolean isEnd();

	public abstract String whenIsMiss();

	public abstract String whenIsSpare();

	public abstract String whenIsStrike();

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
