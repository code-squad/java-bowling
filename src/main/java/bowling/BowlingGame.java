package bowling;

public class BowlingGame {

	public static void main(String[] args) {

		Frames frames = new Frames();
		String result = ResultView.basicPrint();
		while (frames.isGameEnd()) {
			Frame frame = new NormalFrame();
			if (frames.countFrame() == 10)
				frame = new FinalFrame();
			while (frame.isNotEnd()) {
				frame.addScore(InputView.inputScore(frames.countFrame()));
				result += frame.changeFormat();
				ResultView.printScore(result);
			}
			frames.addFrame(frame);
		}
	}
}
