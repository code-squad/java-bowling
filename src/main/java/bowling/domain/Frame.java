package bowling.domain;

abstract public class Frame {

	private int frameNum;
	private int firstDownPin;
	private int secondDownPin;

	public Frame(int frameNum, int firstDownPin, int secondDownPin) {
		this.frameNum = frameNum;
		this.firstDownPin = firstDownPin;
		this.secondDownPin = secondDownPin;
	}

	public Frame(int frameNum, int firstDownPin) {
		this.frameNum = frameNum;
		this.firstDownPin = firstDownPin;
	}

	abstract String getDownPin();
	abstract String checkSecondPin();

	public String checkFirstPin() {
		if (isStrike()) {
			return "X";
		}
		return String.valueOf(firstDownPin);
	}

	public Boolean isStrike() {
		return Score.isStrike(firstDownPin);
	}

	public Boolean isStrkeSecondPin() {
		return Score.isStrike(secondDownPin);
	}

	public Boolean isSpare() {
		return Score.isSpare(firstDownPin, secondDownPin);
	}

	public Boolean isSpare(int thirdDownPin) {
		return Score.isSpare(secondDownPin, thirdDownPin);
	}

	public int getSecondDownPin() {
		return secondDownPin;
	}

}
