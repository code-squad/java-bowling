package bowling.frame;

import bowling.frame.state.End;
import bowling.frame.state.lastFrame.LastFrameReady;

public class LastFrame extends Frame {

	private LastFrame(int no) {
		this.no = no;
		this.state = new LastFrameReady();

	}

	public static Frame create(int no) {
		return new LastFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		this.state = this.state.bowl(score);
		if (this.state instanceof End) {
			return this;
		}
		return this;
	}

}
