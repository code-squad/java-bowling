package bowling.domain;

abstract public class Frame {

	private int num;
	private int firstDownPin;
	private int secondDownPin;

	public Frame(int num, int firstDownPin, int secondDownPin) {
		this.num = num;
		this.firstDownPin = firstDownPin;
		this.secondDownPin = secondDownPin;
	}

	abstract String getDownPin();

	public int getFirstDownPin() {
		return firstDownPin;
	}

	public int getSecondDownPin() {
		return secondDownPin;
	}

	public int getNum() {
		return num;
	}

	public Boolean isFisrtThrowStrike() {
		return firstDownPin == 10;
	}

	public Boolean isSecondThrowSpare(int inputThrowScore) {
		return firstDownPin == (10 - inputThrowScore);
	}

	public String calcSecondDownPin() {
		if (getSecondDownPin() == 0) {
			return " ";
		}
		if (isSecondThrowSpare(getSecondDownPin())) {
			return "/";
		}
		return String.valueOf(getSecondDownPin());
	}

}
