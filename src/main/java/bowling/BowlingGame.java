package bowling;


public class BowlingGame {

	public static void main(String[] args) throws Exception {
		gameStart();
	}

	public static void gameStart() throws Exception {
		String result = ResultView.basicPrint();
		Player player = new Player(InputView.inputName());
		Frames frames = new Frames();
		Frame frame = makeFirstFrame();
		while (frames.addFrame(frame)) {
			int score = InputView.inputScore(frames.countFrame());
			if(frame.validateAddScore(score) == null)
				continue;
			frame = frame.addScore(frame.validateAddScore(score));
			frames.getFrameScore();
			result = frames.getStatusResult();
			ResultView.printScore(result, player);
		}

	}

	private static Frame makeFirstFrame() {
		return new NormalFrame(0);
	}

}
