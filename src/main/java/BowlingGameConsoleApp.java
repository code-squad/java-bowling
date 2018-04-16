import domain.frame.FinalFrame;
import domain.frame.Frame;
import domain.frame.NormalFrame;
import view.InputView;
import view.OutputView;

import java.util.LinkedList;

public class BowlingGameConsoleApp {
	public static void main(String[] args) {
		String playerName = InputView.showGetPlayerNameView();
		LinkedList<Frame> frames = new LinkedList<>();
		
		while (! (frames.getLast() instanceof FinalFrame && frames.getLast().isComplete())) {
			Frame currentFrame = InputView.showGetFrameResultView(frames.size(), frames.getLast());
			frames.set(currentFrame.getFrameNumber() - 1, currentFrame);
		}
		OutputView.showStatusBoardView(playerName, frames);
	}
}
