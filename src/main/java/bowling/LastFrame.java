package bowling;

public class LastFrame extends Frame {
	private Pins bonusBowl;
	private boolean endGame;

	public LastFrame(FrameNo frameNo) {
		super(frameNo);
	}

	@Override
	public void roll(Pins pinsDown) {
		if (endGame) {
			throw new EndGameException();
		}

		if (frameDone) {
			bonusBowl = pinsDown;
			endGame = true;
			return;
		}

		if (firstRoll == null) {
			firstRoll = pinsDown;
			return;
		}

		if (secondRoll == null) {
			secondRoll = pinsDown;
			endGame = secondRoll.isBonusRoll(firstRoll);
			frameDone = true;
			return;
		}
	}

	@Override
	public Frame getCurrentFrame() {
		return this;
	}

	public int getBonusBowl() {
		return bonusBowl.getPinsDown();
	}

	public boolean isBonusBowlNull() {
		if (bonusBowl == null) {
			return true;
		}
		return false;
	}

	@Override
	public Frame getNextFrame() {
		return this;
	}

	@Override
	public boolean isEndGame() {
		return endGame;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNo() + "]";
	}
}
