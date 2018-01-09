package bowling;

import java.util.ArrayList;

public class ResultView {

	public static void printScore(String name, ArrayList<String> result) {
		System.out.print("|" + "\t" + name + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + result.get(i) + "\t|");
		}
		System.out.println("");
	}

	private static void printFormat() {
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + (i + 1) + "\t" + "|");
		}
		System.out.println();
	}

	public static void printTotalScore(ArrayList<String> totalResult) {
		System.out.print("|   " + "totalScore" + "  |");
		for (int i = 0; i < totalResult.size(); i++) {
			System.out.print("\t" + totalResult.get(i) + "\t|");
		}
		System.out.println("");
	}
	
	public static void drawAllUserScore(ArrayList<Player> playerList) {
		printFormat();
		for (Player player : playerList) {
			printScore(player.name, player.frames.makeResultBoard());
			printTotalScore(player.frames.makePrintResult());
		}
	}

}