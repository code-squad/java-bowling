package bowling;

import com.sun.istack.internal.NotNull;

public abstract class Frame {
	protected FrameNo frameNo;
	protected boolean frameDone = false;
	protected Pins firstRoll;
	protected Pins secondRoll;
	
	public Frame(FrameNo frameNo) {
		this.frameNo = frameNo;
	}

	public abstract void roll(Pins pinsDown);

	public abstract Frame getCurrentFrame();
	
	public abstract Frame getNextFrame();
	
	public abstract boolean isEndGame();
	
	public int getFrameNo() {
		return frameNo.getFrame();
	}

	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}
	
	public boolean isFirstRollNull() {
		if (firstRoll == null) {
			return true;
		}
		return false;
 	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}
	
	public boolean isSecondRollNull() {
		if (secondRoll == null) {
			return true;
		}
		return false;
	}
	
	public int getFrameScore() {
		return getFirstRoll() + getSecondRoll();
	}
	
	public boolean isFrameDone() {
		return frameDone;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNo() + "]";
	}
}
