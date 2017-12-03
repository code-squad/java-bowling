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
		if (pin.getPin() == 10) {
			return true;
		}
		return false;
	}

	public static boolean isSpare(Pin firstPin, Pin secondPin) {
		if (firstPin.getPin() + secondPin.getPin() == 10) {
			return true;
		}
		return false;
	}
	
	private static String createFirstStatus(Pin pin) {
		if (isStrike(pin)) {
			return "X";
		}
		return pin.getPin() + "";
	}
	
	private static String createSecondStatus(Pin firstPin, Pin secondPin) {
		if (isSpare(firstPin, secondPin)) {
			return firstPin.getPin() + "|/";
		}
		if (secondPin.getPin() == 0) {
			return firstPin.getPin() + "|-";
		}
		return firstPin.getPin() + "|" + secondPin.getPin();
	}
	
//	// 한 프레임에 대한 status 생성.
//	public static String createStatus(int... pins) {
//		if (pins.length == 1) {
//			return createFirstStatus(pins[0]);
//		}
//		int firstPitch = pins[0];
//		int secondPitch = pins[1];
//		// 두번째 투구일때. spare나 미스인경우.
//		return createSecondStatus(firstPitch, secondPitch);
//	}

//	
//	public static String createStatusFor10thFrame(int... pins) {
//		// 첫번째 핀이 스트라이크 일때.
//		if (isStrike(pins[0])) {
//			return whenFirstPinIsStrike(pins);
//		}
//		// 첫번째 핀이 스트라이크 아니고, 투구 개수가 1개 혹은 2개 일때.
//		if (pins.length != 3) {
//			return createStatus(pins);
//		}
//		// 첫번째 핀이 스트라이크 아니고, 투구 개수가 3개 일때.
//		return createSecondStatus(pins[0], pins[1]) + createFirstStatus(pins[2]);
//	}
	
//	private static String whenFirstPinIsStrike(int... pins) {
//		String status = "X";
//		if (pins.length == 2) {
//			return status + createFirstStatus(pins[1]);
//		}
//		if (pins.length == 3) {
//			return status + createSecondStatus(pins[1], pins[2]);
//		}
//		return status;
//	}
	
//	public static boolean isStrike(int falledPin) {
//	if (falledPin == 10) {
//		return true;
//	}
//	return false;
//}
	
//	public static boolean isSpare(int firstPitch, int secondPitch) {
//		if (firstPitch + secondPitch == 10) {
//			return true;
//		}
//		return false;
//	}

//	private static String createFirstStatus(int falledPin) {
//		if (isStrike(falledPin)) {
//			return "X";
//		}
//		return falledPin + "";
//	}

//	private static String createSecondStatus(int firstPitch, int secondPitch) {
//		if (isSpare(firstPitch, secondPitch)) {
//			return firstPitch + "|/";
//		}
//		if (secondPitch == 0) {
//			return firstPitch + "|-";
//		}
//		return firstPitch + "|" + secondPitch;
//	}

}
