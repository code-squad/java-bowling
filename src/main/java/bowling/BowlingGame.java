package bowling;

public class BowlingGame {

	public static void main(String[] args) throws Exception {
		gameStart();
	}

	public static void gameStart() throws Exception {
		Players players = new Players(InputView.inputName(InputView.inputPlayerNum()));
		while (!players.isGameOver()) {
			int score = InputView.inputScore(players.getCurrentPlayer());
			players.makeFrame();
			if (players.validateAddScore(score) == null)
				continue;
			players.addScore(score);
			for (Player player : players.getPlayers()) {
				ResultView.printScore(player);
				ResultView.printTotalScore(player.getFrameScore());
			}
		}

	}

}
