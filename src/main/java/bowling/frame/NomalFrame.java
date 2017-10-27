package bowling.frame;

import bowling.frame.state.Ready;

public class NomalFrame extends Frame {

	public NomalFrame() {
		state = new Ready();
	}

	public NomalFrame(int no) {
		this.state = new Ready();
		this.no = no;
	}
}
