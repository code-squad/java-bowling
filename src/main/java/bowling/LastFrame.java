package bowling;

public class LastFrame extends Frame {
	private Pins bonusBowl;

	public LastFrame(int frameNo) {
		super(new FrameNo(frameNo));
	}

	@Override
	public void roll(int pinsDown) {
		if (isEndGame()) {
			throw new EndGameException();
		}

		if (canRollBonusBowl()) {
			bonusBowl = new Pins(pinsDown);
		}
		setPinsDown(pinsDown);
	}

	public boolean isBonusBowlNull() {
		return bonusBowl == null;
	}

	@Override
	public Frame getCurrentFrame() {
		return this;
	}

	@Override
	public int getCurrentFrameNo() {
		return getCurrentFrame().getFrameNo();
	}

	@Override
	public Frame getNextFrame() {
		return this;
	}

	@Override
	public boolean isEndFrame() {
		if (bonusBowl != null) {
			return true;
		}
		
		if (!isFirstRollNull() && !isSecondRollNull() && getFrameScore() < 10) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEndGame() {
		return isEndFrame();
	}

	public int getBonusBowl() {
		return bonusBowl.getPinsDown();
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNo() + "]";
	}
}
