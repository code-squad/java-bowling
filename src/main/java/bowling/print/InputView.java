package bowling.print;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.InvalidPinNumberException;

public class InputView {
	private Scanner sc = null;

	public InputView(Scanner sc) {
		this.sc = sc;
	}

	public void endConsole() {
		sc.close();
	}

	public String getName() {
		System.out.print("플레이어 이름은?(3 english letters)?");
		return sc.next();
	}

	private int checkInvalidInput(int pin) {
		if (pin < 0) {
			throw new InvalidPinNumberException("0 이상의 값을 입력해주세요.");
		} else if (pin > 10) {
			throw new InvalidPinNumberException("10 이하의 값을 입력해주세요.");
		}
		return pin;
	}

	public int getThrowedPin(int frameNum) {
		try {
			return inputThrowedPin(frameNum);
		} catch (InputMismatchException ime) {
			System.out.println("정수를 입력해주세요.");
			sc.next(); // 없으면 inputMismatchException 무한루프
			return getThrowedPin(frameNum);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 얜 무한루프 안 탐
			return getThrowedPin(frameNum);
		}
	}

	public int inputThrowedPin(int frameNum) throws InputMismatchException {
		System.out.printf("\n%1d프레임 투구 : ", frameNum);
		return checkInvalidInput(sc.nextInt());
	}
}
