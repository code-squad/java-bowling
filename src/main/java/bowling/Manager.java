package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bowling.frame.Frame;
import bowling.frame.LastFrame;
import bowling.frame.state.Second;
import bowling.frame.state.Spare;
import bowling.frame.state.Strike;
import bowling.result.Result;
import bowling.view.BowlingFormView;
import bowling.view.BowlingResultView;

public class Manager {
	List<Frame> frames = new ArrayList<>();
	List<Integer> scores = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Result result = new Result(frames, scores);
	String name = BowlingFormView.inputName(scanner);
	Frame frame;
	int score;

	public void run() {
		boolean gameFlag = true;
		boolean frameFlag = true;
		BowlingResultView.show(name, result);
		while (gameFlag) {
			FrameFlagCheck(frameFlag, frames.size());
			frame.bowl(BowlingFormView.inputScore(name, scanner));
			gameFlag = isLastFrame(frame);
			frameFlag = stateCheck(frame);
			// scoreCalculate(frameFlag, frame);
			BowlingResultView.show(name, result);
		}
	}

	private void scoreCalculate(Frame frame) {
		score += frame.getEndScore();
	}

	private boolean isLastFrame(Frame frame) {
		if (frame instanceof LastFrame) {
			return false;
		}
		return true;
	}

	private boolean stateCheck(Frame frame) {
		if (frame.isEnd()) {
			frames.add(frame);
			scoreCalculate(frame);
			scores.add(score);
			return true;
		}
		return false;
	}

	private void FrameFlagCheck(boolean frameFlag, int size) {
		if (frameFlag) {
			frame = Frame.create(frames.size());
			frameFlag = false;
		}
	}

	// private void endFrameCheck(Frame frame) {
	// if (frames.size() == 10) {
	// stateCheck(frame);
	// return;
	// }
	// stateCheck(frame);
	// }

	// private void stateCheck(Frame frame) {
	// if (frame.getState() instanceof Strike) {
	// score += frame.getEndScore();
	// return;
	// }
	// BowlingResultView.show(name, result);
	// second(frame);
	// }

	// private void second(Frame frame) {
	// frame.bowl(BowlingFormView.inputScore(name, scanner));
	// score += frame.getEndScore();
	// }
	//
	// private static Frame frameGenarator(int size) {
	// if (size < 9) {
	// return new NomalFrame();
	// }
	// return new LastFrame();
	// }
}
