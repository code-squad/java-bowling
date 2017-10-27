package bowling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bowling.frame.Frame;
import bowling.frame.LastFrame;
import bowling.frame.NomalFrame;
import bowling.frame.state.First;
import bowling.frame.state.LastFrameFirst;
import bowling.frame.state.Spare;
import bowling.frame.state.Strike;
import bowling.result.Result;
import bowling.view.BowlingFormView;
import bowling.view.BowlingResultView;

public class Manager {
	List<Frame> frames = new ArrayList<>();
	String name = BowlingFormView.inputName();
	List<Integer> scores = new LinkedList<>();
	List<Integer> strikeScore = new ArrayList<>();
	List<Integer> spareScore = new ArrayList<>();
	Result result = new Result(frames, scores);
	int score;

	public void run() {
		boolean gameFlag = true;
		boolean frameFlag = true;
		Frame frame = new NomalFrame(1);
		BowlingResultView.show(name, result);
		while (gameFlag) {
			frame = FrameFlagCheck(frameFlag, frame);
			frame.bowl(BowlingFormView.inputScore(name));
			frameFlag = stateCheck(frame);
			gameFlag = isLastFrame(frame);
			BowlingResultView.show(name, result);
		}
	}

	private boolean isLastFrame(Frame frame) {
		if (frame instanceof LastFrame) {
			return !frame.isEnd();
		}
		return true;
	}

	private boolean stateCheck(Frame frame) {
		if (frame.isEnd()) {
			if (frame.getState() instanceof Strike) {
				frames.add(frame);
				scores.add(frames.indexOf(frame), 10);
				return true;
			}
			if (frame.getState() instanceof Spare) {
				return true;
			}
			scores.add(nomalFrameCalcu(frames.indexOf(frame), frame.getEndScore()));
			return true;
		}
		if ((frame.getState() instanceof First) || (frame.getState() instanceof LastFrameFirst)) {
			frames.add(frame);
			return false;
		}
		return false;
	}

	private Integer nomalFrameCalcu(int index, int endScore) {
		if (index == 0) {
			return endScore;
		}
		endScore += scores.get(index - 1);
		return endScore;
	}

	private Frame FrameFlagCheck(boolean frameFlag, Frame frame) {
		if (frameFlag) {
			frameFlag = false;
			return Frame.create(frames.size());
		}
		return frame;
	}

}
