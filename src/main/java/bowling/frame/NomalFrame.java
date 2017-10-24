package bowling.frame;

import bowling.frame.state.Ready;

public class NomalFrame extends Frame {

	public NomalFrame() {
		state = new Ready();
	}
}
