package bowling.domain;

abstract public class Frame {

	private int frameNum;
	protected int firstDownPin;
	protected int secondDownPin;

	public Frame(int frameNum, int firstDownPin, int secondDownPin) {
		this.frameNum = frameNum;
		this.firstDownPin = firstDownPin;
		this.secondDownPin = secondDownPin;
	}

	public Frame(int frameNum, int firstDownPin) {
		this.frameNum = frameNum;
		this.firstDownPin = firstDownPin;
	}

	public String getDownPin() {
		if (firstDownPin == 10) {
			return "X  ";
		}
		if (Score.isSpare(firstDownPin, secondDownPin)) {
			return firstDownPin + "|/";
		}
		return firstDownPin + "|" + secondDownPin;
	}

}
