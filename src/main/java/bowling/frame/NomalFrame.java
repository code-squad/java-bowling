package bowling.frame;

import java.util.List;

import bowling.frame.state.Ready;

public class NomalFrame extends Frame {

	public NomalFrame(int no) {
		this.no = no;
		this.state = new Ready();
	}

	@Override
	public boolean isEnd() {
		return state.isEnd();
	}

}