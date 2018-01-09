package bowling;

import java.util.ArrayList;

public class ResultView {

	public static void printScore(String score, Player player) {
		printFormat();
		System.out.print("|" + "\t" + player.toString() + "\t" + "|");
		System.out.print(score + "\t");
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

	public static void printTotalScore(ArrayList<Integer> frameScore, Player player) {
		System.out.println();
		System.out.print("|" + "\t" + player.toString() + "\t" + "|");
		for (Integer totalScore : frameScore) {
			System.out.print("\t" + totalScore + "\t" + "|");
		}
		System.out.println();
	}

}
