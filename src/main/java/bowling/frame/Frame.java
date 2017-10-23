package bowling.frame;

import bowling.frame.state.Ready;
import bowling.frame.state.State;

public class Frame {
	private Frame next;
	private State state;
	private int no;

	public Frame(int no) {
		this.state = new Ready();
		this.no = no;
	}

	public Frame bowl(int countOfPin) {
		state = state.bowl(countOfPin);
		if (state.isFinish()) {
			next = new Frame(no + 1);
			return next;
		}
		return this;
	}

	public int getNo() {
		return no;
	}
}
