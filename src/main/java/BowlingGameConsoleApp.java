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
		
		do {
			int pinCount = InputView.showGetPinCountView(frames);
			Frame currentFrame = frames.isEmpty() ? new NormalFrame(Frame.MIN_FRAME_NUMBER, pinCount) : frames.getLast().bowl(pinCount);
			if (!frames.contains(currentFrame)) {
				frames.add(currentFrame);
			}
			OutputView.showStatusBoardView(playerName, frames);
		} while(! (frames.getLast() instanceof FinalFrame && frames.getLast().isComplete()));

	}
}
