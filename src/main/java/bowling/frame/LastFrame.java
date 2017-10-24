package bowling.frame;

import bowling.frame.state.Ready;

public class LastFrame extends Frame {
	public LastFrame() {
		state = new Ready();
	}
}
