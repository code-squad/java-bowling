package bowling;

import state.State;

public class LastFrame extends Frame {
	private Pins firstBonusBowl;
	private Pins secondBonusBowl;

	public LastFrame(int frameNo, State state) {
		super(new FrameNo(frameNo), state);
	}

	@Override
	public void roll(int pinsDown) {
		if (isEndGame()) {
			throw new EndGameException();
		}

		if (firstBonusBowl != null && getState().isStrike()) {
			secondBonusBowl = new Pins(pinsDown);
			return;
		}

		if (getState().canRollBonusBowl()) {
			firstBonusBowl = new Pins(pinsDown);
			return;
		}
	}

	@Override
	public Frame getCurrentFrame() {
		return this;
	}

	@Override
	public int getCurrentFrameNo() {
		return getCurrentFrame().getIntFrameNo();
	}

	@Override
	public Frame getNextFrame() {
		return this;
	}

	@Override
	public boolean isEndGame() {
		if (getState().isStrike() && secondBonusBowl != null) {
			return true;
		}

		if (!getState().isStrike() && getState().canRollBonusBowl() && firstBonusBowl != null) {
			return true;
		}
		return false;
	}

	public Pins getFirstBonusBowl() {
		return firstBonusBowl;
	}

	public int getIntFirstBonusBowl() {
		return firstBonusBowl.getPinsDown();
	}

	public boolean isfirstBonusBowlNull() {
		return firstBonusBowl == null;
	}
	
	public Pins getSecondBonusBowl() {
		return secondBonusBowl;
	}

	public int getIntSecondBonusBowl() {
		return secondBonusBowl.getPinsDown();
	}
}
