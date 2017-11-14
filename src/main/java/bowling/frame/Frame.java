package bowling.frame;

import bowling.frame.state.State;
import bowling.result.Result;

public abstract class Frame {
	protected int no;
	protected State state;
	protected Frame next;
	protected int frameEndScore;

	public static Frame createFrame(int no) {
		if (no == 10) {
			return LastFrame.create(no);
		}
		return NomalFrame.create(no);
	}

	abstract public Frame bowl(int score);

	public State getState() {
		return state;
	}

	public int getNo() {
		return this.no;
	}

	public Frame getNext() {
		return this.next;
	}

	public int getFrameEndScore() {
		return frameEndScore;
	}

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
