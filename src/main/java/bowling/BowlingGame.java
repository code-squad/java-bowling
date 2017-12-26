package bowling;

import java.util.ArrayList;

public class BowlingGame {
	public static ArrayList<String> makeResultBoard() {
		ArrayList<String> resultBoard = new ArrayList<String> ();
		for (int i = 0; i < 10; i++) {
			resultBoard.add("");
		}
		return resultBoard;
	}
	
	public static Frame makeFinalFrame(Frames frames, Frame frame) {
		if (frames.countFrame() == 9) {
			frame = new FinalFrame();
		}
		return frame;
	}
	
	public static void playOneFrame(Frames frames, String playerName, ArrayList<String> resultList) {
		Frame frame = new Frame();

		frame = makeFinalFrame(frames, frame);
		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(frames.countFrame()));
			resultList = frames.updateResultBoard(resultList, frame);
			ResultView.printScore(playerName, resultList);
		}
		frames.addFrame(frame);
	}
	//------------------MAIN START-------------------
	public static void main(String[] args) {
		String playerName = InputView.inputName();
		Frames frames = new Frames();
		ArrayList<String> resultList = makeResultBoard();

		while (frames.isGameEnd()) {
			playOneFrame(frames, playerName, resultList);
		}
	}
}