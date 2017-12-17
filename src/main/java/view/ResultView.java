package view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import model.Game;
import model.Player;
import model.Status;

public class ResultView {
	public static void printTurn(Game game) {
		System.out.print(game.getCurrentPlayer().getName() + "'s turn :");
	}

	public static void printBlankTable(String playerName) {
		printBlankSecondLine(playerName);
		printBlankThirdLine();
	}

	public static void printFirstLine() {
		DecimalFormat twodigits = new DecimalFormat("00");
		String firstLine = "|  NAME  |";
		for (int i = 1; i < 11; i++) {
			firstLine += "  " + twodigits.format(i) + "  |";
		}
		System.out.println(firstLine);
	}

	private static void printBlankSecondLine(String playerName) {
		String secondLine = "|   " + playerName + "   |";
		for (int i = 1; i < 11; i++) {
			secondLine += "      |";
		}
		System.out.println(secondLine);
	}

	private static void printBlankThirdLine() {
		String thirdLine = "|         |";
		for (int i = 1; i < 11; i++) {
			thirdLine += "      |";
		}
		System.out.println(thirdLine);
	}

	public static void printResults1(Game game) {
		printFirstLine();
		List<String> result = game.getPlayers().stream().map(player -> returnStatus(game, player))
				.collect(Collectors.toList());
		System.out.println(result);
	}

	public static void printResults(Game game) {
		printFirstLine();
		for (Player player : game.getPlayers()) {
			System.out.println(returnResult(game, player));
		}
	}

	private static String returnResult(Game game, Player player) {
		return returnStatus(game, player) + "\n" + returnScores(game, player);
	}

	private static String returnStatus(Game game, Player player) {
		List<Status> allStatus = game.getPlayerStatus(player);
		String secondLine = "|   " + player.getName() + "   |";
		for (Status status : allStatus) {
			secondLine += "   " + status.getStatus() + "   |";
		}
		for (int j = allStatus.size() + 1; j < 11; j++) {
			secondLine += "      |";
		}
		return secondLine;
	}

	private static String returnScores(Game game, Player player) {
		List<String> totalScores = game.getPlayerScore(player);
		String thirdLine = "|        |";
		for (String score : totalScores) {
			thirdLine += "   " + score + "   |";
		}
		for (int j = totalScores.size() + 1; j < 11; j++) {
			thirdLine += "      |";
		}
		return thirdLine;
	}
}
