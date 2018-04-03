package bowling;

public class Frame {
	private Pins firstRoll ;
	private Pins secondRoll;
	
	public void roll(int pinsDown) {
		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		secondRoll = new Pins(pinsDown);
	}

	public Pins getFirstRoll() {
		return firstRoll;
	}

	public Pins getSecondRoll() {
		return secondRoll;
	}
}
