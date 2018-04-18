package bowling.domain;

public class NormalFrame extends Frame {

	private NormalFrame(Pin pin, Score score) {
		super(pin.getPin(0), pin.getPin(1), score);
	}

	private NormalFrame(int firstDownPin, Score score) {
		super(firstDownPin, score);
	}

	public static NormalFrame of(Pin pin, int beforeScore) {
		if (Pin.isStrike(pin.getPin(0))) {
			return new NormalFrame(pin.getPin(0), Score.ofStrike(pin.beforePlusNow(beforeScore)));
		}

		if (pin.isSpare()) {
			return new NormalFrame(pin, Score.ofSpare(pin.beforePlusNow(beforeScore)));
		}

		return new NormalFrame(pin, Score.of(pin.beforePlusNow(beforeScore)));
	}

	public String getDownPin() {
		return checkFirstPin() + checkSecondPin();
	}

	public String checkSecondPin() {
		if (isStrike()) {
			return "  ";
		}
		if (isSpare()) {
			return "|/";
		}
		return "|" + getSecondDownPin();
	}

}
