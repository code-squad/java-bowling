package bowling;

import java.util.ArrayList;

public class ResultView {

	public static void printScore(String name, ArrayList<String> result) {
		printFormat(name);
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + result.get(i) + "\t|");
		}
	}

	private static void printFormat(String name) {
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + (i + 1) + "\t" + "|");
		}
		System.out.println();
		System.out.print("|" + "\t" + name + "\t" + "|");
	}
	
	public static void printTotalScore(ArrayList<String> totalResult) {
		System.out.println("");
		System.out.print("|   " + "totalScore" + "  |");
		for (int i = 0; i < totalResult.size(); i++) {
			System.out.print("\t" + totalResult.get(i) + "\t|");
		}
	}

}