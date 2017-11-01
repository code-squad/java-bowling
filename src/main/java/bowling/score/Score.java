package bowling.score;

import java.util.ArrayList;
import java.util.List;

import bowling.frame.Frame;
import bowling.frame.state.Spare;
import bowling.frame.state.State;
import bowling.frame.state.Strike;

public class Score {
	private List<Integer> scores;

	public Score(State state) {
		// this.score = state.getEachFinalFrameScore();
	}

	public Score(List<Frame> frames) {
		scores = Create(frames);
	}

	private List<Integer> Create(List<Frame> frames) {
		int score = 0;
		scores = new ArrayList<>();
		for (int i = 0; i < frames.size(); i++) {
			try {
				scores.add(scoreCalculate(score, i, frames));
				score = scores.get(i);
			} catch (IndexOutOfBoundsException e) {
				return scores;
			}
		}
		return scores;
	}

	private Integer scoreCalculate(int score, int i, List<Frame> frames) throws IndexOutOfBoundsException {
		if (frames.get(i).getState() instanceof Strike) {
			if (frames.get(i + 1).getState() instanceof Strike) {
				return score += frames.get(i).getState().getEachFinalFrameScore()
						+ frames.get(i + 1).getState().getEachFinalFrameScore()
						+ frames.get(i + 2).getState().getEachFinalFrameScore();
			}
			return score += frames.get(i).getState().getEachFinalFrameScore()
					+ frames.get(i + 1).getState().getEachFinalFrameScore();
		}
		if (frames.get(i).getState() instanceof Spare) {
			return score += frames.get(i).getState().getEachFinalFrameScore()
					+ frames.get(i + 1).getState().getFirstScore();
		}
		return score += frames.get(i).getState().getEachFinalFrameScore();
	}

	public static Score calculate(State state) {
		return new Score(state);
	}

	public static Score calculate(List<Frame> frames) {
		return new Score(frames);
	}

	public List<Integer> getScores() {
		return scores;
	}
}
