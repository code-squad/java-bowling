package bowling.frame;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.state.State;
import bowling.result.Result;
import bowling.score.Score;

public abstract class Frame {

	private static final Logger log = LoggerFactory.getLogger(Frame.class);

	private int no;
	private List<Integer> scores = new ArrayList<>();

	public Frame(int no) {
		this.no = no;
	}

	public int getNo() {
		return this.no;
	}

	public void addScore(int score) {
		scores.add(score);
	}

	protected Frame nextFrame() {
		if (no == 9) {
			return LastFrame.create(no + 1);
		}
		return NormalFrame.create(no + 1);
	}

	abstract public Frame bowl(int score);

	abstract public State getState();

	abstract public Frame getNext();

	abstract public int getFrameEndScore();

	public Result result(Score score) {
		return new Result(this, score);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		return no == other.no;
	}

	public List<Integer> getScore() {
		return scores;
	}

	public Score frameToScore(Frame frame) {
		return new Score(frame);
	}
}
