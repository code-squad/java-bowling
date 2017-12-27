package bowling;

public class BowlingGame {
	public static Frame makeFinalFrame(Frames frames, Frame frame) {
		if (frames.countFrame() == 9) {
			frame = new FinalFrame();
		}
		return frame;
	}

	public static void playOneFrame(Frames frames, String playerName) {
		Frame frame = new Frame();
		frame = makeFinalFrame(frames, frame);
		frames.addFrame(frame);

		while (frame.isNotEnd()) {
			try {
				frame.addScore(InputView.inputScore(frames.countFrame(), frame));
			}
			catch (InputException inputException) {
			}
			ResultView.printScore(playerName, frames.makeResultBoard());
		}
	}

	//------------------MAIN START-------------------
	public static void main(String[] args) {
		String playerName = InputView.inputName();
		Frames frames = new Frames();

		while (frames.isGameEnd()) {
			playOneFrame(frames, playerName);
		}
	}
}