package bowling;

public class BowlingGame {

	public static void playOneFrame(Frames frames, String playerName) {

		Frame frame = new Frame();
		String result = ResultView.basicPrint();

		if(frames.countFrame() == 9){
			frame = new FinalFrame();
		}
		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(frames.countFrame()));
			result += frame.changeFormat();
			frames.makeResultBoard(result, frames.recentIndex());
			ResultView.printScore(playerName, frames);
		}
		frames.addFrame(frame);
	}

	public static void main(String[] args) {

		String playerName = InputView.inputName();
		Frames frames = new Frames();

		while (frames.isGameEnd()) {
			playOneFrame(frames, playerName);
		}
	}
}