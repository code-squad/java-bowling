package bowling;

import state.Ready;
import state.State;

public abstract class Frame {
	private FrameNo frameNo;
	private State state;
	private Pins firstRoll;
	private Pins secondRoll;
	
	public Frame(FrameNo frameNo) {
		this.frameNo = frameNo;
		this.state = new Ready();
	}

	public Frame(FrameNo frameNo, State state) {
		this.frameNo = frameNo;
		this.state = state;
	}

	public abstract Frame getCurrentFrame();

	public abstract int getCurrentFrameNo();

	public abstract Frame getNextFrame();

	public abstract boolean isEndGame();
	
	public void roll(int pinsDown) {
		if (state.isFinish()) {
			getNextFrame().roll(pinsDown);
			return;
		}
		changeState(pinsDown);
		setPinsDown(pinsDown);
	}
	
	private void setPinsDown(int pinsDown) {
		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		setSecondPinsDown(pinsDown);
	}

	private void setSecondPinsDown(int pinsDown) {
		secondRoll = new Pins(pinsDown);
		secondRoll.checkPinsValid(firstRoll);
	}

	private void changeState(int pinsDown) {
		if (getFirstRoll() != null) {
			state = state.update(getIntFirstRoll() + pinsDown);
			return;
		}
		state = state.update(pinsDown);
	}

	public State getState() {
		return state;
	}

	public FrameNo getFrameNo() {
		return frameNo;
	}

	public int getIntFrameNo() {
		return frameNo.getFrame();
	}

	public Pins getFirstRoll() {
		return firstRoll;
	}

	public int getIntFirstRoll() {
		return getFirstRoll().getPinsDown();
	}

	public boolean isFirstRollNull() {
		return getFirstRoll() == null;
	}

	public Pins getSecondRoll() {
		return secondRoll;
	}

	public int getIntSecondRoll() {
		return getSecondRoll().getPinsDown();
	}

	public boolean isSecondRollNull() {
		return getSecondRoll() == null;
	}

	public int getFrameScore() {
		return getIntFirstRoll() + getIntSecondRoll();
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getIntFrameNo() + "]";
	}
}
