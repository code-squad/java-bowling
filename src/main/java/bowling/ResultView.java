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
	public static void printStatus(Status playerStatus) {
		System.out.print("|" + "\t" + playerStatus.getPlayer().getName() + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + playerStatus.getScore().getAccRec().get(i) + "\t" + "|");
		}
		System.out.print("\n\n");
	}
}
