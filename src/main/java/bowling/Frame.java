package bowling;

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

	public int getFrameNo() {
		return frameNo;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + frameNo + "]";
	}
}
