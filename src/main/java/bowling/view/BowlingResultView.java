package bowling.view;

import java.util.List;

import bowling.model.Players;
import bowling.model.Result;

public class BowlingResultView {
	private static final String top = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

	public static void showResult(Players players) {
		System.out.println(top);
		for (int i = 0; i < players.getSize(); i++) {
			StringBuilder knockedPins = makeNameSpace(players.getPalyerName(i));
			StringBuilder sumScores = new StringBuilder("|       |");
			Result result = players.getResult(i);
			knockedPins.append(makeScores(result.getKnockedPins()));
			sumScores.append(makeScores(result.getSumScores()));
			System.out.println(knockedPins);
			System.out.println(sumScores);
		}
	}

	private static StringBuilder makeNameSpace(String name) {
		StringBuilder sb = new StringBuilder();
		return sb.append("|  ").append(name).append(" |");
	}

	private static StringBuilder makeScores(List<String> scores) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append("  ").append(scores.get(i)).append("   |");
			// makeBlankSpace(sb).append("|");
		}
		return sb;
	}

	private static StringBuilder makeBlankSpace(StringBuilder sb) {
		while (sb.length() % 8 != 0) {
			sb.append(" ");
		}
		return sb;
	}

}
