package bowling.frame;

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

	@Override
	public int[] getScore() {
		return state.getScore();
	}
}