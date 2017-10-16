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
		List<Integer> scores = new ArrayList<>();
		player.getKnockedPins(knockedPins, scores);

		sb.append("| ").append(player.getName()).append("  |");
		for (String knockedPin : knockedPins) {
			sb.append("  ").append(knockedPin).append(" |");
		}
		sb.append("\n").append("|       |");
		for (int score : scores) {
			sb.append("   ").append(score).append("   |");
		}
		sb.append("\n");
	}
}

// 결과 폼 예제
// 플레이어 이름은(3 english letters)?: PJS
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | | | | | | | | | | |
// | | | | | | | | | | | |
//
// PJS's turn : 10
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | X | | | | | | | | | |
// | | | | | | | | | | | |
//
// PJS's turn : 8
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | X | 8 | | | | | | | | |
// | | | | | | | | | | | |
//
// PJS's turn : 2
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | X | 8|/ | | | | | | | | |
// | | 20 | | | | | | | | | |
//
// PJS's turn : 7
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | X | 8|/ | 7 | | | | | | | |
// | | 20 | 37 | | | | | | | | |
//
// PJS's turn : 0
// | NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
// | PJS | X | 8|/ | 7|- | | | | | | | |
// | | 20 | 37 | 44 | | | | | | | |
//
// PJS's turn : 10
