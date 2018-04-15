import domain.frame.Frame;
import domain.frame.NormalFrame;
import view.InputView;
import view.OutputView;

import java.util.LinkedList;

public class BowlingGameConsoleApp {
	public static void main(String[] args) {
		String playerName = InputView.showGetPlayerNameView();
		LinkedList<Frame> frames = new LinkedList<>();
		
		while (frames.getLast() instanceof NormalFrame
			|| !frames.getLast().isComplete()) {
			Frame currentFrame = InputView.showGetFrameResultView(frames.size(), frames.getLast());
			if(! frames.getLast().equals(currentFrame)) {
				frames.add(currentFrame);
			}
		}
		OutputView.showStatusBoardView(playerName, frames);
	}
}
