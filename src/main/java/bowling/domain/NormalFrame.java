package bowling.domain;

public class NormalFrame extends Frame {

	private NormalFrame(int num, int firstDownPin) {
		super(num, firstDownPin, 0);
	}

	private NormalFrame(int num, int firstDownPin, int secondDownPin) {
		super(num, firstDownPin, secondDownPin);
	}

	public static NormalFrame of(int num, int firstDownPin, int secondDownPin) {
		return new NormalFrame(num, firstDownPin, secondDownPin);
	}

	public static NormalFrame of(int num, Frame frame, int secondDownPin) {
		return new NormalFrame(num, frame.getFirstDownPin(), secondDownPin);
	}

	@Override
	String getDownPin() {
		if (isFisrtThrowStrike()) {
			return "X" + "  ";
		}
		return getFirstDownPin() + "|" + calcSecondDownPin();
	}

}
