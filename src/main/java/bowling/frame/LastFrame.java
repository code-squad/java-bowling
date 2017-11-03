package bowling.frame;

import bowling.frame.state.LastReady;

public class LastFrame extends Frame {
	public LastFrame() {
		this.no = 10;
		this.state = new LastReady();
	}

	@Override
	public boolean isEnd() {
		return state.isEnd();
	}
}