package bowling.view;

import bowling.model.Player;

import java.util.Arrays;

public class OutputView {
	private static void printStaticView() {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
	}

	public static void printScoreView(Player player, String[] scores) {
		printStaticView();
		String view = "|  " + player.toString() + " |";
		System.out.print(view);
		Arrays.stream(scores).forEach(score -> {
			System.out.print(checkScore(score));
		});
		System.out.println();
	}

	private static String checkScore(String score) {
		if (score == null) {
			return "      |";
		}
		int len = score.length();

		return " " + score + "      ".substring(0, 5 - len) + "|";
	}
}
