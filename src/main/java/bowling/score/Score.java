package bowling.score;

import java.util.ArrayList;
import java.util.List;

import bowling.frame.Frame;
import bowling.frame.state.BowlingEnd;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameSecond;
import bowling.frame.state.normalframe.NormalFrameSpare;
import bowling.frame.state.normalframe.NormalFrameStrike;

public class Score {
	private List<Integer> scores = new ArrayList<>();

	public Score(Frame frame) {
		calculateScore(frame);
	}

	private void calculateScore(Frame frame) {
		while (frame != null) {
			State state = frame.getState();
			isState(frame, state);
			frame = frame.getNext();
		}
	}

	private void isState(Frame frame, State state) {
		if (state instanceof NormalFrameStrike) {
			scores.add(calculateStrike(frame));
		} else if (state instanceof NormalFrameSpare) {
			scores.add(calculateSpare(frame));

		} else if (state instanceof NormalFrameSecond) {
			scores.add(calculateMiss(frame));

		} else if (state instanceof BowlingEnd) {
			scores.add(calculateLastFrame(frame));
		}
	}

	private Integer calculateLastFrame(Frame frame) {
		int temp = scores.get(scores.size() - 1);
		State state = frame.getState();
		return temp + state.getFinalScore();
	}

	private Integer calculateMiss(Frame frame) {
		int temp = setUpInitialValue();
		State state = frame.getState();
		return temp + state.getFinalScore();
	}

	private Integer calculateSpare(Frame frame) {
		int temp = setUpInitialValue();
		try {
			State state = frame.getState();
			temp += state.getFinalScore();
			frame = frame.getNext();
			state = frame.getState();
			temp += state.getFirstScore();
		} catch (NullPointerException e) {
			return null;
		}
		return temp;
	}

	private Integer calculateStrike(Frame frame) {
		int temp = setUpInitialValue();
		try {
			State state = frame.getState();
			temp += state.getFinalScore();
			frame = frame.getNext();
			state = frame.getState();
			if (state instanceof NormalFrameStrike) {
				temp += state.getFinalScore();
				frame = frame.getNext();
				state = frame.getState();
				if (state instanceof NormalFrameStrike) {
					return temp += state.getFinalScore();
				}
				return temp += state.getFirstScore();
			}
			temp += state.getFirstScore() + state.getSecondScore();
		} catch (NullPointerException e) {
			return null;
		}
		return temp;
	}

	public List<Integer> get() {
		return scores;
	}

	private int setUpInitialValue() {
		if (scores.size() == 0) {
			return 0;
		}
		return scores.get(scores.size() - 1);
	}
}
