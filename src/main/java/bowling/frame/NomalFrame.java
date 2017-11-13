package bowling.frame;

import bowling.frame.state.End;
import bowling.frame.state.nomalFrame.NomalFrameReady;

public class NomalFrame extends Frame {

	private NomalFrame(int no) {
		this.no = no;
		this.state = new NomalFrameReady();
	}

	public static Frame create(int no) {
		return new NomalFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
		if (this.state instanceof End) {
			this.next = Frame.createFrame(no + 1);
			return next;
		}
		return this;
	}
}
