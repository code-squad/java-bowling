import domain.frame.Frame;
import domain.frame.NormalFrame;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameConsoleApp {
	public static void main(String[] args) {
		String playerName = InputView.showGetPlayerNameView();
		List<Frame> frames = new ArrayList<>();
		Frame currentFrame;
		do {
			int pinCount = InputView.showGetPinCountView(frames);
			currentFrame = frames.isEmpty() ? new NormalFrame(pinCount) : frames.get(frames.size() - 1).bowl(pinCount);
			if (!frames.contains(currentFrame)) {
				frames.add(currentFrame);
			}
			OutputView.showStatusBoardView(playerName, frames);
		} while(!currentFrame.isFinalFrame() || !currentFrame.isComplete());
	}
}
