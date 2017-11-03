package bowling.frame;

import java.util.List;

import bowling.frame.state.State;

public abstract class Frame {

	protected int no;
	protected State state;

	public static Frame create(int no) {
		if (no == 10) {
			return new LastFrame();
		}
		return new NomalFrame(no);
	}

	public int getNo() {
		return this.no;
	}

	public State getState() {
		return this.state;
	}

	public State bowl(int score) {
		return state = state.bowl(score);
	}

	public static Frame create(int i, Frame frame) {
		if (frame.isEnd()) {
			return create(i);
		}
		return frame;
	}

	abstract public boolean isEnd();

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
		if (no != other.no)
			return false;
		return true;
	}

}