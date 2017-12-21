package bowling;

public class BowlingGame {

	public static void main(String[] args) {

		String playerName = InputView.inputName();
		Frames frames = new Frames();
		String result = ResultView.basicPrint();
		while (frames.isGameEnd()) {
			//playOneFrame(frames, result, playerName);
			Frame frame = new Frame();
			if(frames.countFrame() == 10){
				frame = new FinalFrame();
			}
			while (frame.isNotEnd()) {
				frame.addScore(InputView.inputScore(frames.countFrame()));
				result += frame.changeFormat();
				ResultView.printScore(playerName, result);
			}
			frames.addFrame(frame);
		}
	}
}