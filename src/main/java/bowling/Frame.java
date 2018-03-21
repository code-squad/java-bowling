package bowling;

import state.Finish;
import state.FirstBowl;
import state.State;

public abstract class Frame {
	protected int frameNo;
	protected State state;
	protected Frame nextFrame;

	public Frame(int frameNo) {
		this.frameNo = frameNo;
		state = (State) new FirstBowl();
	}

	public abstract void InputBowl(Pins pins);

	public int getFirstRoll() {
		return state.getFirstRoll();
	}

	public int getSecondRoll() {
		return state.getSecondRoll();
	}

	public Frame getNextFrame() {
		return nextFrame;
	}
	
	public Frame getCurrentFrame() {
		if (state instanceof Finish & nextFrame != null) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}

	public int getFrameNo() {
		return frameNo;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + frameNo + "]";
	}
}
