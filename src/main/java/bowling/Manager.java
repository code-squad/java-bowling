package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bowling.frame.Frame;
import bowling.frame.LastFrame;
import bowling.frame.NomalFrame;
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
	int score;

	public void run() {
		BowlingResultView.show(name, result);
		while (frames.size() < 10) {
			Frame frame = Manager.frameGenarator(frames.size());
			frame.bowl(BowlingFormView.inputScore(name, scanner));
			frames.add(frame);
			endFrameCheck(frame);
			scores.add(score);
			BowlingResultView.show(name, result);
		}
	}

	private void endFrameCheck(Frame frame) {
		if (frame.getState() instanceof Strike) {
			score += frame.getEndScore();
			return;
		}
		BowlingResultView.show(name, result);
		System.out.println(frame.getState());
		second(frame);
	}

	private void second(Frame frame) {
		frame.bowl(BowlingFormView.inputScore(name, scanner));
		System.out.println(frame.getState());
		score += frame.getEndScore();
	}

	private static Frame frameGenarator(int size) {
		if (size < 9) {
			return new NomalFrame();
		}
		return new LastFrame();
	}
}
