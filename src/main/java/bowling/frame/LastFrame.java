package bowling.frame;

import bowling.frame.state.LastReady;

public class LastFrame extends Frame {

	private LastFrame next;

	public LastFrame() {
		this.no = 10;
		state = new LastReady();
	}
}
