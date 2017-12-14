package bowling.print;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import exception.InvalidNameException;
import exception.InvalidPinNumberException;

public class InputView {
	private Scanner sc = null;

	public InputView(Scanner sc) {
		this.sc = sc;
	}

	public void endConsole() {
		sc.close();
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
			System.out.println(e.getMessage());
			return getThrowedPin(frameNum);
		}
	}

	public int inputThrowedPin(int frameNum) throws InputMismatchException {
		System.out.printf("\n%1d프레임 투구 : ", frameNum);
		return checkInvalidInput(sc.nextInt());
	}

	public List<String> getPlayers() {
		int count = 0;
		try {
			System.out.print("How many people?");
			count = sc.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("정수를 입력해주세요.");
			sc.next(); 
			return getPlayers();			
		}
		return getNamesOfPlayers(count);
	}
	
	private List<String> getNamesOfPlayers(int count) {
		List<String> players = new ArrayList<>();
		for(int i=0; i<count; i++) {
			players.add(getName());
		}
		return players;
	}
	
	private String getName() {
		System.out.print("플레이어 이름은?(3 english letters)?");
		String name = sc.next();
		try {
			checkName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			getName();
		}
		return name;
	}
	
	private String checkName(String name) {
		if(!Pattern.matches("^[a-zA-Z]*$", name)) {
			//코다시: raw Exception 사용하지 말고 subclass Exception 사용하시오
			throw new InvalidNameException("영어만 써주세요.");
		}
		if(name.length() != 3) {
			throw new InvalidNameException("이름은 영어 3글자입니다.");
		}
		return name;
	}
}