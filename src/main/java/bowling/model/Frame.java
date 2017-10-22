package bowling.model;

import bowling.model.state.Ready;
import bowling.model.state.State;

public class Frame {
	private Frame nextFrame;
	private State state;
	int no;

	public Frame(int no) {
		this.state = new Ready();
		this.no = no;
	}

	public Frame bowl(int knockedPins) {
		state = state.bowl(knockedPins);
		if (state.isEnd()) {
			nextFrame = new Frame(no + 1);
			return nextFrame;
		}
		return this;
	}

	public int getNo() {
		return no;
	}
}
