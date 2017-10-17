package bowling.view;

import java.util.ArrayList;
import java.util.List;

import bowling.model.Player;

public class BowlingResultView {
	public final static String top = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

	public static void showResults(List<Player> players) {
		StringBuilder sb = new StringBuilder(top);
		sb.append("\n");

		for (Player player : players) {
			showResult(player, sb);
		}
		System.out.println(sb);
	}

	private static void showResult(Player player, StringBuilder sb) {
		List<String> knockedPins = new ArrayList<>();
		List<String> scores = new ArrayList<>();
		player.getKnockedPins(knockedPins, scores);

		sb.append("| ").append(player.getName()).append("  |");
		for (String knockedPin : knockedPins) {
			sb.append("  ").append(knockedPin).append("  |");
		}
		sb.append("\n").append("|       |");
		for (String score : scores) {
			sb.append("   ").append(score).append("   |");
		}
		sb.append("\n");
	}
}
