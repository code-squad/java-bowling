package bowling.frame;

import bowling.frame.state.LastFrameReady;

public class LastFrame extends Frame {

	public LastFrame() {
		state = new LastFrameReady();
	}

}