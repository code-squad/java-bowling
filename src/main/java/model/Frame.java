package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
	private int frameNum;
	List<Integer> pins = new ArrayList<>();

	public Frame(int frameNum) {
		this.frameNum = frameNum;
	}
	
	public int getFrameNum() {
		return frameNum;
	}

	
	public void addPins(int falledPin) {
		this.pins.add(falledPin);
	}
	
	public List<Integer> getPins() {
		return this.pins;
	}
	
	public abstract String decideStatus();

	public abstract boolean isEnd();
	
	public abstract Frame addAfterDecide(int falledPin);

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
