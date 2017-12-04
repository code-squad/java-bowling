package model;

public class Status {
	// status 생성에만 관여.
	
	// 한 프레임에 대한 status 생성.
	public static String createStatus(Pin... pins) {
		if (pins.length == 1) {
			return createFirstStatus(pins[0]);
		}
		Pin firstPitch = pins[0];
		Pin secondPitch = pins[1];
		// 두번째 투구일때. spare나 미스인경우.
		return createSecondStatus(firstPitch, secondPitch);
	}

	public static String createStatusFor10thFrame(Pin...pins) {
		// 첫번째 핀이 스트라이크 일때.
		if (isStrike(pins[0])) {
			return whenFirstPinIsStrike(pins);
		}
		// 첫번째 핀이 스트라이크 아니고, 투구 개수가 1개 혹은 2개 일때.
		if (pins.length != 3) {
			return createStatus(pins);
		}
		// 첫번째 핀이 스트라이크 아니고, 투구 개수가 3개 일때.
		return createSecondStatus(pins[0], pins[1]) + createFirstStatus(pins[2]);
	}
	private static String whenFirstPinIsStrike(Pin...pins) {
		String status = "X";
		if (pins.length == 2) {
			return status + createFirstStatus(pins[1]);
		}
		if (pins.length == 3) {
			return status + createSecondStatus(pins[1], pins[2]);
		}
		return status;
	}

	public static boolean isStrike(Pin pin) {
		if (pin.getPin() == Pin.getPinMaxValue()) {
			return true;
		}
		return false;
	}

	public static boolean isSpare(Pin firstPin, Pin secondPin) {
		if (firstPin.getPin() + secondPin.getPin() == Pin.getPinMaxValue()) {
			return true;
		}
		return false;
	}
	
	private static String createFirstStatus(Pin pin) {
		if (isStrike(pin)) {
			return "X";
		}
		if(pin.getPin() == Pin.getPinMinValue()) {
			return "-";
		}
		return pin.getPin() + "";
	}
	
	private static String createSecondStatus(Pin firstPin, Pin secondPin) {
		if (isSpare(firstPin, secondPin)) {
			return firstPin.getPin() + "|/";
		}
		if (secondPin.getPin() == Pin.getPinMinValue()) {
			return firstPin.getPin() + "|-";
		}
		return firstPin.getPin() + "|" + secondPin.getPin();
	}
}
