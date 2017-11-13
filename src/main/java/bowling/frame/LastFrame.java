package bowling.frame;

import bowling.frame.state.BowlingEnd;
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
		if (state instanceof BowlingEnd) {
			this.Endscore += state.getFinalScore();
		}
		return this;
	}

}
