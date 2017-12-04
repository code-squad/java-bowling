package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.Frame;

public class ResultView {

	public static void printFrameNum(int frameNum) {
		System.out.print(frameNum + "프레임 투구 : ");
	}

	public static void printBlankTable(String playerName) {
		printFirstLine();
		printBlankSecondLine(playerName);
	}

	private static void printFirstLine() {
		DecimalFormat twodigits = new DecimalFormat("00");
		String firstLine = "|  NAME  |";
		for (int i = 1; i < 11; i++) {
			firstLine += "  " + twodigits.format(i) + "  |";
		}
		System.out.println(firstLine);
	}

	private static void printBlankSecondLine(String playerName) {
		String secondLine = "|   " + playerName + "  |";
		for (int i = 1; i < 11; i++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}

	public static List<String> makeStatus(List<Frame> frames) {
		List<String> allStatus = new ArrayList<>();
		for (Frame frame : frames) {
			if (!frame.getPins().isEmpty()) {
				allStatus.add(frame.decideStatus());
			}
		}
		return allStatus;
	}

	public static void printStatus(String playerName, List<Frame> frames) {
		List<String> allStatus = makeStatus(frames);
		printFirstLine();
		String secondLine = "|   " + playerName + "  |";
		for (String status : allStatus) {
			secondLine += "   " + status + "   |";
		}
		for (int j = allStatus.size() + 1; j < 11; j++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}

}
