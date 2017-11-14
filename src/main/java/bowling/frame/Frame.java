package bowling.frame;

import bowling.frame.state.State;
import bowling.result.Result;

public abstract class Frame {
	private int no;
	private int beforeFrameScore;

	public Frame(int no, int frameScore) {
		this.no = no;
		this.beforeFrameScore = frameScore;
	}

	public int getNo() {
		return this.no;
	}

	public int getBeforeFrameScore() {
		return beforeFrameScore;
	}

	protected Frame nextFrame(int frameScore) {
		if (no == 9) {
			return LastFrame.create(no + 1, frameScore);
		}
		return NormalFrame.create(no + 1, frameScore);
	}

	abstract public Frame bowl(int score);

	abstract public State getState();

	abstract public Frame getNext();

	abstract public int getFrameEndScore();

	public Result result() {
		return new Result(this);
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
