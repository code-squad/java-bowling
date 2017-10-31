package bowling.frame;

import bowling.frame.state.Ready;

public class NomalFrame extends Frame {

	public NomalFrame(int no) {
		this.no = no;
		state = new Ready();
	}
}
