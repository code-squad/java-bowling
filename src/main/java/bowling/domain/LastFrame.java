package bowling.domain;

public class LastFrame extends Frame {

	private int thirdDownPin;

	public LastFrame(Pin pin, Score score) {
		super(pin.getPin(0), pin.getPin(1), score);
	}

	public LastFrame(Pin pin, int thirdDownPin, Score score) {
		super(pin.getPin(0), pin.getPin(1), score);
		this.thirdDownPin = thirdDownPin;
	}

	public LastFrame(int pin, Score score) {
		super(pin, score);
	}

	public static LastFrame of(Pin pin, int beforeScore) {

		if (pin.isStrike()) {
			return new LastFrame(pin.getPin(0), Score.ofStrike(pin.beforePlusNow(beforeScore)));
		}

		if (pin.isSpare()) {
			return new LastFrame(pin, Score.ofSpare(pin.beforePlusNow(beforeScore)));
		}

		if (pin.size() == 3) {
			return new LastFrame(pin, pin.getPin(2), Score.of(pin.beforePlusNow(beforeScore)));
		}
		return new LastFrame(pin, Score.of(pin.beforePlusNow(beforeScore)));
	}

	public String getDownPin() {
		return checkFirstPin() + "|" + checkSecondPin() + "|" + checkThirdPin();
	}

	public String checkSecondPin() {
		if (isSpare()) {
			return "/";
		}
		if (isStrkeSecondPin()) {
			return "X";
		}
		return String.valueOf(getSecondDownPin());
	}

	public String checkThirdPin() {
		if (isSpare()) {
			return String.valueOf(thirdDownPin);
		}
		if (isSpare(thirdDownPin)) {
			return "/";
		}
		if (Pin.isStrike(thirdDownPin)) {
			return "X";
		}
		return String.valueOf(thirdDownPin);
	}
}
