package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	int frameNum;
	List<Integer> pins = new ArrayList<>();

	public Frame(int frameNum) {
		this.frameNum = frameNum;
	}

	public abstract List<Integer> getPins();

	public int getFrameNum() {
		return frameNum;
	}

	public abstract void addPins(int falledPin);

	public abstract String decideStatus();

	public abstract boolean isEnd();

	public abstract Frame returnFrame();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frameNum;
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
		return true;
	}

}
