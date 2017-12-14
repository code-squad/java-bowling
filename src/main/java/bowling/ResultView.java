package bowling;

import java.util.ArrayList;

public class ResultView {
	public static void printFormat() {
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + (i + 1) + "\t" + "|");
		}
		System.out.print("\n");
	}
	public static void printStatus(String name, ArrayList<String> score) {
		System.out.print("|" + "\t" + name + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + score.get(0) + "\t" + "|");
		}
		System.out.print("\n");
	}
}
