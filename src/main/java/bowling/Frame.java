package bowling;

import state.Ready;
import state.State;

public abstract class Frame {
	private FrameNo frameNo;
	private State state;
//	private int totalScore;
	private Pins firstRoll;
	private Pins secondRoll;

	public Frame(FrameNo frameNo) {
		this.frameNo = frameNo;
		this.state = new Ready();
	}

	public void roll(int pinsDown) {
		if (state.isFinish()) {
			getNextFrame().roll(pinsDown);
			return;
		}
		setPinsDown(pinsDown);
	}

	public abstract Frame getCurrentFrame();
	
	public abstract int getCurrentFrameNo();

	public abstract Frame getNextFrame();

	public abstract boolean isEndGame();
	
	public void setPinsDown(int pinsDown) {
		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			state = state.update(pinsDown);
			return;
		}
		setSecondPinsDown(pinsDown);
	}

	public void setSecondPinsDown(int pinsDown) {
		if (secondRoll == null) {
			secondRoll = new Pins(pinsDown);
			secondRoll.checkPinsValid(frameNo, firstRoll);
			state = state.update(getFrameScore());
		}
	}

	public boolean isEndFrame() {
		if (firstRoll != null && firstRoll.checkFrameDone()) {
			return true;
		}

		if (firstRoll != null && secondRoll != null) {
			return true;
		}

		return false;
	}

	public boolean canRollBonusBowl() {
		if (firstRoll != null && secondRoll != null) {
			return secondRoll.isBonusRoll(firstRoll);
		}
		return false;
	}

	public int getFrameNo() {
		return frameNo.getFrame();
	}

	public FrameNo getFrameNoObj() {
		return frameNo;
	}

	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}

	public Pins getFirstRollObj() {
		return firstRoll;
	}

	public boolean isFirstRollNull() {
		return firstRoll == null;
	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}

	public Pins getSecondRollObj() {
		return secondRoll;
	}

	public boolean isSecondRollNull() {
		return secondRoll == null;
	}

	public int getFrameScore() {
		return getFirstRoll() + getSecondRoll();
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNo() + "]";
	}
}
