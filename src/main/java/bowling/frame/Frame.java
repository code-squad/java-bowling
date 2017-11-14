package bowling.frame;

import bowling.frame.state.State;
import bowling.result.Result;

public abstract class Frame {
	private int no;
	private int frameScore;

	protected Frame(int no) {
		this.no = no;
	}

	public Frame(int no, int frameScore) {
		this.no = no;
		this.frameScore = frameScore;
	}

	public int getNo() {
		return this.no;
	}

	public int getFrameScore() {
		return frameScore;
	}

	protected Frame nextFrame() {
		if (no == 9) {
			return LastFrame.create(no + 1);
		}
		return NormalFrame.create(no + 1);
	}

	protected Frame nextFrame(int frameScore) {
		if (no == 9) {
			return LastFrame.lastCreate(no + 1, frameScore);
		}
		return NormalFrame.create(no + 1, frameScore);
	}

	abstract public Frame bowl(int score);

	abstract public State getState();

	abstract public Frame getNext();

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
