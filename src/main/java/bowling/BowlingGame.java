package bowling;

import java.util.ArrayList;

public class BowlingGame {

	public static void main(String[] args) throws Exception  {
		gameStart();
	}

	public static void gameStart() throws Exception {
		Frames frames = new Frames();
		String result = ResultView.basicPrint();
		while (frames.isGameEnd()) {
			Frame frame = new NormalFrame(new ArrayList<Integer>());
			if (frames.countFrame() == 10)
				frame = new FinalFrame(new ArrayList<Integer>());
			while (frame.isNotEnd()) {
				int score = InputView.inputScore(frames.countFrame());
				try {
					frame.validateAddScore(score);
				} catch (MyException e) {
					System.out.println(e.getErrorMessage());
					return;
				}
				frame.addScore(score);
				result += frame.getStatusResult();
				ResultView.printScore(result);
			}
			frames.addFrame(frame);
		}
	}

}
