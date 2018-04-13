package bowling;

import frame.Frame;
import state.State;

public class FrameInfo {

	private Pins firstRoll;
	private Pins secondRoll;
	private TotalScore totalScore;
	private int frameNo;
	private Frame nextFrame;
	private State state;
	
	public FrameInfo(int frameNo, Frame nextFrame, State state) {
		this.frameNo = frameNo;
		this.nextFrame = nextFrame;
		this.state = state;
	}
	
	public FrameInfo(int frameNo, Frame nextFrame, State state, TotalScore totalScore) {
		this.frameNo = frameNo;
		this.nextFrame = nextFrame;
		this.state = state;
		this.totalScore = totalScore;
	}

	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}
	
	public void setFirstRoll(Pins firstRoll) {
		this.firstRoll = firstRoll;
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
	
	public void setSecondRoll(Pins secondRoll) {
		this.secondRoll = secondRoll;
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

	public int getInputFrameNo() {
		if (state.isFrameEnd()) {
			return frameNo + 1;
		}
		return frameNo;
	}
	
	public int getFrameNo() {
		return frameNo;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

	public State getState() {
		return state;
	}

	public TotalScore getTotalScore() {
		return totalScore;
	}
	
}
