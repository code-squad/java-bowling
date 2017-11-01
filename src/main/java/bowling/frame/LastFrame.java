package bowling.frame;

import bowling.frame.state.LastReady;

public class LastFrame extends Frame {

	public LastFrame() {
		this.no = 10;
		state = new LastReady();
	}
}
