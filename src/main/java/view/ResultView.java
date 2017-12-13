package view;

import java.text.DecimalFormat;
import java.util.List;

import model.Bowling;

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

	public static void printResults(String playerName, Bowling bowling) {
		printFirstLine();
		System.out.println(returnStatus(playerName, bowling));
		System.out.println(returnScores(bowling));
	}
	
	private static String returnStatus(String playerName, Bowling bowling) {
		List<String> allStatus = bowling.makeStatus();
		String secondLine = "|   " + playerName + "   |";
		for (String status : allStatus) {
			secondLine += "   " + status + "   |";
		}
		for (int j = allStatus.size() + 1; j < 11; j++) {
			secondLine += "      |";
		}
		return secondLine;
	}

	private static String returnScores(Bowling bowling) {
		List<String> totalScores = bowling.getTotal();
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
