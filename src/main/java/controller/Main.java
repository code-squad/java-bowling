package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import view.InputView;
import view.ResultView;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private List<Integer> falledPins = new ArrayList<>();
	private List<Integer> falledPinsFor10thFrame = new ArrayList<>();
	public Map<Integer, String> currFrame = new HashMap<>();
	public static int frameNum = 1;
	List<Map<Integer, String>> frames = new ArrayList<>();

	public static void main(String[] args) {
		String playerName = InputView.getPlayerName(sc);
		ResultView.printBlankTable(playerName);
		Main main = new Main();
		while (main.getFrames().size() < 9) {
			printFrameNum();
			int falledPin = InputView.getFalledPin(sc);
			main.createNextFrameOrNot(falledPin);
			ResultView.printStatus(playerName, main);
		}
		do {
			printFrameNum();
			int falledPin = InputView.getFalledPin(sc);
			main.createTenthFrame(falledPin);
			ResultView.printStatus(playerName, main);
		} while(Main.frameNum < 11);
		System.out.println("게임이 끝났습니다.");
	}

	public static void printFrameNum() {
		System.out.print(Main.frameNum + "프레임 투구 : ");
	}

	// 한번의 투구에 대한 status 생성하는 메소드.
	public boolean isStrike(int falledPin) {
		if (falledPin == 10) {
			return true;
		}
		return false;
	}

	// 한 프레임에 대한 status 생성.
	public String createStatus(int falledPin) {
		falledPins.add(falledPin);
		if (isFirstPitch()) {
			return createFirstStatus(falledPin);
		}
		int firstPitch = falledPins.get(0);
		int secondPitch = falledPins.get(1);
		// falledPins reset
		if (falledPins.size() >= 2) {
			falledPins.clear();
		}
		// 두번째 투구일때. spare나 미스인경우.
		return createSecondStatus(firstPitch, secondPitch);
	}

	private String createSecondStatus(int firstPitch, int secondPitch) {
		if (isSpare(firstPitch, secondPitch)) {
			return firstPitch + "|/";
		}
		if (secondPitch == 0) {
			return firstPitch + "|-";
		}
		return firstPitch + "|" + secondPitch;
	}

	private String createFirstStatus(int falledPin) {
		if (isStrike(falledPin)) {
			falledPins.clear();
			return "X";
		}
		return falledPin + "";
	}

	public boolean isFirstPitch() {
		if (falledPins.size() == 1) {
			return true;
		}
		return false;
	}

	private boolean isSpare(int firstPitch, int secondPitch) {
		if (firstPitch + secondPitch == 10) {
			return true;
		}
		return false;
	}

	// generalization.
	public List<Map<Integer, String>> createNextFrameOrNot(int falledPin) {
		if (this.falledPins.size() == 0) {// 전 프레임이 꽉 찬 경우.
			return createNextFrame(falledPin);
		}
		return replaceCurrFrame(falledPin);
	}

	private List<Map<Integer, String>> replaceCurrFrame(int falledPin) {
		String status = createStatus(falledPin);
		Map<Integer, String> frame = setCurrFrame(falledPin, status);
		frames.set(frames.size() - 1, frame);
		Main.frameNum++;
		return frames;
	}

	private List<Map<Integer, String>> createNextFrame(int falledPin) {// 전 프레임이 꽉 찬 경우.
		String status = createStatus(falledPin);
		Map<Integer, String> newFrame = setCurrFrame(falledPin, status);
		frames.add(frames.size(), newFrame);
		if (this.falledPins.size() == 0) {
			Main.frameNum++;
			return frames;
		}
		return frames;
	}

	private Map<Integer, String> setCurrFrame(int falledPin, String status) {
		Map<Integer, String> newFrame = new HashMap<>();
		newFrame.put(Main.frameNum, status);
		this.currFrame = newFrame;
		return newFrame;
	}

	public List<Map<Integer, String>> createTenthFrame(int falledPin){
		// 점수 생성.
		falledPinsFor10thFrame.add(falledPin);
		int[] pins = falledPinsFor10thFrame.stream().mapToInt(s -> s).toArray();
		String status = createStatusFor10thFrame(pins);
		Map<Integer, String> tenthFrame = create10thFrame(status);
		if(falledPinsFor10thFrame.size() >= 3 || status == "X" + "X") {
			falledPinsFor10thFrame.clear();
			Main.frameNum++;
		}
		if(this.getFrames().size() != 10) {
			frames.add(this.getFrames().size(), tenthFrame);
			return frames;
		}
		frames.set(this.getFrames().size()-1, tenthFrame);
		return frames;	
	}
	
	public Map<Integer, String> create10thFrame(String status){
		Map<Integer, String> tenthFrame = new HashMap<>();
		tenthFrame.put(Main.frameNum, status);
		return tenthFrame;
	}
	

	public String createStatusFor10thFrame(int... pins) {
		String status = "";
		if (pins.length == 1) {
			return createFirstStatus(pins[0]);
		}
		if (pins.length == 2) {
			if (pins[0] == 10) {
				if (pins[1] == 10) {
					return "X" + "X";
				}
				return "X" + createFirstStatus(pins[1]);
			}
			return createSecondStatus(pins[0], pins[1]);
		}
		if (pins[0] == 10) {
			return "X" + createSecondStatus(pins[1], pins[2]);
		}
		status = createSecondStatus(pins[0], pins[1]) + createFirstStatus(pins[2]);
		return status;

	}

	public List<Map<Integer, String>> getFrames() {
		return frames;
	}
//	public String ifIsStrike(int... pins){
//		if(pins.length == 1) {
//			return createFirstStatus(pins[0]);
//		}
//		if(!isStrike(pins[0])) {// strike 아닐때.
//			return ifIsSpare(pins[1]);
//		}
//		return ifIsStrike(pins[1]);
//	}
//	public String ifIsStrike1(int... pins){
//		if(isStrike(pins[0])) {
//			return "X";
//		}
//		if(!isStrike(pins[0])) {// strike 아닐때.
//			return ifIsSpare(pins[1]);
//		}
//		return ifIsStrike(pins[1]);
//	}
//	
//	public String ifIsSpare(int... pins) {
//		if(!isSpare(falledPins.get(0), falledPins.get(1))) { // spare 아닐때.
//			String status = createSecondStatus(falledPins.get(0), falledPins.get(1));
//			return status;
//		}
//		return ifIsStrike(pins[1]);
//	}

}
