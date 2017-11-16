package bowling.frame;

import java.util.ArrayList;
import java.util.List;

import bowling.frame.state.State;
import bowling.result.Result;
import bowling.score.Score;

public abstract class Frame {

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

	public Result result(Score score) {
		return new Result(this, score);
	}

	public List<Integer> getScore() {
		return scores;
	}

	public Score score(Frame frame) {
		return new Score(frame);
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
}