package bowling;

import java.util.ArrayList;

public class BowlingGame {
	public static Frame makeFinalFrame(Frames frames, Frame frame) {
		if (frames.countFrame() == 9) {
			frame = new FinalFrame();
		}
		return frame;
	}

	public static void playOneFrame(Frames frames, String playerName) {
		ArrayList<Integer> totalResult = new ArrayList<Integer> ();
		Frame frame = new Frame();
		frame = makeFinalFrame(frames, frame);
		frames.addFrame(frame);

		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(frames.countFrame(), frame));
			ResultView.printScore(playerName, frames.makeResultBoard());
			
			totalResult = frames.makeTotalScoreBoardform();
			ResultView.printTotalScore(totalResult);
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