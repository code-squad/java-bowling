package bowling;

public class FrameScore {

	private Pins firstRoll;
	private Pins secondRoll;

	public FrameScore(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	public FrameScore(Pins firstRoll, Pins secondRoll) {
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
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

}
