package bowling;

public class BowlingGame {

	public static void main(String[] args) throws Exception {
		gameStart();
	}

	public static void gameStart() throws Exception {
		
		Players players = new Players(InputView.inputName(InputView.inputPlayerNum()));
		Frame frame = makeFirstFrame();
		while (!players.isGameOver()) {
			int score = InputView.inputScore(players.getCurrentPlayer());
			if (frame.validateAddScore(score) == null)
				continue;
			System.out.println(frame.getFrameNum() + " = " + players.getCurrentPlayer());
			frame.addScore(frame.validateAddScore(score));
			frame = players.checkFrame(players.getCurrentPlayer().addFrame(frame));
			players.getCurrentPlayer().setNextFrame(frame);
			for (Player player : players.getPlayers()) {
				Frames frames = new Frames(player.frames);
				String result = ResultView.basicPrint();
				result += frames.getStatusResult();
				ResultView.printScore(result, player);
				ResultView.printTotalScore(frames.getFrameScore(), player);
				
			}
		}

	}

	private static Frame makeFirstFrame() {
		return new NormalFrame(0);
	}

}
