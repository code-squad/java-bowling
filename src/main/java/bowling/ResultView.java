package bowling;

import java.util.ArrayList;

public class ResultView {

	public static void printScore(Player player) {
		printFormat();
		System.out.print("|" + "\t" + player.toString() + "\t" + "|");
		System.out.print(player.getStatusResult() + "\t");
	}

	public static String basicPrint() {
		return "";
	}

	private static void printFormat() {
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + (i + 1) + "\t" + "|");
		}
		System.out.println();
	}

	public static void printTotalScore(ArrayList<Integer> totalScore) {
		System.out.println();
		System.out.print("|" + "\t" + "\t" + "|");
		for (Integer score : totalScore) {
			System.out.print("\t" + score + "\t" + "|");
		}
		System.out.println();
	}

}
