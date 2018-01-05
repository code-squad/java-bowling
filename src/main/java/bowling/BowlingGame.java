package bowling;

public class BowlingGame {
	private static Frame bowl(Frames frames, Frame frame, String playerName) {
		frames.addFrame(frame);
		frame = takeInput(frames, frame, playerName);
		return frame;
	}
	
	private static Frame takeInput(Frames frames, Frame frame, String playerName) {
		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(frame.getFrameNo(), frame));
			frames.updateFrames(frame);
			ResultView.printScore(playerName, frames.makeResultBoard());
		}
		return frame;
	}

	private static Frame checkFrame(Frame frame) {
		if (!frame.isNotEnd()) {
			return frame.addScore(0);
		}
		return frame;
	}

	public static void playOneFrame(Frames frames, String playerName) {
		if (frames.isNotStart()) {
			Frame frame = new Frame(1);
			frame = bowl(frames, frame, playerName);
			return;
		}

		Frame frame = frames.getLastFrame();
		frame = checkFrame(frame);
		frame = bowl(frames, frame, playerName);
		return;
	}

	//------------------MAIN START-------------------
	public static void main(String[] args) {
		String playerName = InputView.inputName();
		Frames frames = new Frames();

		while (frames.isGameEnd()) {
			playOneFrame(frames, playerName);

			ResultView.printTotalScore(frames.makePrintResult());
		}
	}
}