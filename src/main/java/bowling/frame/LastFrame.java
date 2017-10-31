package bowling.frame;

import bowling.state.LastReady;

public class LastFrame extends Frame {
	public LastFrame(int no) {
		super(no, new LastReady());

	}
}
