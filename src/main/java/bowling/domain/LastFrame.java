package bowling.domain;

public class LastFrame extends Frame {

	int thridDownPin;

	private LastFrame(int num, int firstDownPin, int secondDownPin, int thridDownPin) {
		super(num, firstDownPin, secondDownPin);
		this.thridDownPin = thridDownPin;
	}

	public static LastFrame of(int num, Frame frame, int thridDownPin) {
		if (frame.isFisrtThrowStrike()) {
			return new LastFrame(num, frame.getFirstDownPin(), 0, thridDownPin);
		}
		if (frame.getSecondDownPin() != 0) {
			return new LastFrame(num, frame.getFirstDownPin(), frame.getSecondDownPin(), thridDownPin);
		}
		return new LastFrame(num, frame.getFirstDownPin(), thridDownPin, 0);
	}

	public static LastFrame of(int num, int firstDownPin, int secondDownPin, int thridDownPin) {
		return new LastFrame(num, firstDownPin, secondDownPin, thridDownPin);
	}

	@Override
	String getDownPin() {
		if (isFisrtThrowStrike()) {
			return "X" + "||" + getThirdDownPin();
		}
		if (isSecondThrowSpare(getSecondDownPin())) {
			return getFirstDownPin() + "|" + calcSecondDownPin() + "|" + getThirdDownPin();
		}
		return getFirstDownPin() + "|" + calcSecondDownPin();
	}

	public String getThirdDownPin() {
		if (thridDownPin == 0) {
			return "";
		}
		return String.valueOf(thridDownPin);
	}

}
