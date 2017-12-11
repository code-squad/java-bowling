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
		String secondLine = "|   " + playerName + "   |";
		for (int i = 1; i < 11; i++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}

	public static void printResults(String playerName, List<String> allStatus, List<String> totalScores) {
		printFirstLine();
		System.out.println(returnStatus(playerName, allStatus));
		System.out.println(returnScores(totalScores));
	}

	private static String returnStatus(String playerName, List<String> allStatus) {
		String secondLine = "|   " + playerName + "   |";
		for (String status : allStatus) {
			secondLine += "   " + status + "   |";
		}
		for (int j = allStatus.size() + 1; j < 11; j++) {
			secondLine += "      |";
		}
		return secondLine;
	}

	private static String returnScores(List<String> totalScores) {
		String thirdLine = "|        |";
		for (String score : totalScores) {
			thirdLine += "   " + score + "   |";
		}
		for (int j = totalScores.size() + 1; j < 11; j++) {
			thirdLine += "      |";
		}
		return thirdLine;
	}
}
