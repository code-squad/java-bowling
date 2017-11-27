package view;

import java.text.DecimalFormat;

import controller.Main;

public class ResultView {
	public static void printBlankTable(String playerName) {
		printFirstLine();
		printBlankSecondLine(playerName);
	}

	private static void printBlankSecondLine(String playerName) {
		String secondLine = "|   " + playerName + "  |";
		for (int i = 1; i < 11; i++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}

	private static void printFirstLine() {
		DecimalFormat twodigits = new DecimalFormat("00");
		String firstLine = "|  NAME  |";
		for (int i = 1; i < 11; i++) {
			firstLine += "  " + twodigits.format(i) + "  |";
		}
		System.out.println(firstLine);
	}
	public static void printStatus(String playerName, Main main) {
		printFirstLine();
		String secondLine = "|   " + playerName + "  |";
		for (int i = 1; i < main.getFrames().size() + 1; i++) {
			secondLine += "   " + main.getFrames().get(i - 1).get(i) + "   |";
		}
		for (int j = main.getFrames().size() + 1; j < 11; j++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}
}
