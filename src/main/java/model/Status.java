package model;

public class Status {
	// status 생성에만 관여.

	// 한 프레임에 대한 status 생성.
	public static String createStatus(Pin... pins) {
		if (pins[0].isStrike()) {
			return whenFirstPinIsStrike(pins);
		}
		if (pins.length == 1) {
			return createFirstStatus(pins[0]);
		}
		if (pins.length == 2) {
			return createSecondStatus(pins[0], pins[1]);
		}
		return createSecondStatus(pins[0], pins[1]) + createFirstStatus(pins[2]);
	}

	public static String whenFirstPinIsStrike(Pin... pins) {
		String status = "X";
		if (pins.length == 1) {
			return status;
		}
		if (pins.length == 2) {
			return status + createFirstStatus(pins[1]);
		}
		// 핀 개수 3개일때.
		if (pins[1].isStrike()) {
			return status + createFirstStatus(pins[1]) + createFirstStatus(pins[2]);
		}
		return status + createSecondStatus(pins[1], pins[2]);
	}

	private static String createFirstStatus(Pin pin) {
		if (pin.isStrike()) {
			return "X";
		}
		return pin.getPin() + "";
	}

	private static String createSecondStatus(Pin firstPin, Pin secondPin) {
		if (firstPin.isSpare(secondPin)) {
			return firstPin.getPin() + "|/";
		}
		if (secondPin.getPin() == 0) {
			return firstPin.getPin() + "|-";
		}
		return firstPin.getPin() + "|" + secondPin.getPin();
	}
}
