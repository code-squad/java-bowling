package model;

import java.util.ArrayList;
import java.util.List;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}
	
	@Override
	public Frame returnFrame() {
		if(isEnd()) {
			if(this.frameNum == 9) {
				return new TenthFrame(this.frameNum+1);
			}
			return new NormalFrame(this.frameNum+1);
		}
		return this;
	}
	
	@Override
	public void addPins(int falledPin) {
		this.pins.add(falledPin);
	}
	
	@Override
	public String decideStatus() {
		return Status.createStatusFor10thFrame(this.pins.stream().mapToInt(s -> s).toArray());
	}

	@Override
	public boolean isEnd() {
		if(this.pins.isEmpty()) {
			return false;
		}
		if(this.pins.size() >= 2 || this.pins.get(0) == 10) {
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


	@Override
	public List<Integer> getPins() {
		return this.pins;
	}



	
	
	
}
