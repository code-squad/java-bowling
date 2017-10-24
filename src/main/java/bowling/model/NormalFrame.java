package bowling.model;

import bowling.model.state.EndState;
import bowling.model.state.Ready;
import bowling.model.state.Spare;
import bowling.model.state.State;
import bowling.model.state.Strike;
import bowling.model.state.last.LastReady;

public class NormalFrame extends Frame {
	Frame nextFrame;
	State state;
	int no;

	public NormalFrame(int no) {
		this.state = new Ready();
		this.no = no;
	}

	@Override
	public int getNo() {
		return no;
	}

	@Override
	public String getKnockedPins() {
		return state.getKnockedPins();
	}

	@Override
	public Frame bowl(int knockedPins) {
		state = state.bowl(knockedPins);
		if (state.isEnd()) {
			nextFrame = createFrame(no + 1);
			return nextFrame;
		}
		return this;
	}

	@Override
	public int getScore() {
		if (state instanceof EndState) {
			if (state instanceof Spare) {
				return ((EndState) state).getScore() + nextFrame.getFirstScore();
			}
			return ((EndState) state).getScore() + nextFrame.getScore();
		}
		return 0;
	}

	private Frame createFrame(int no) {
		if (no == 10) {
			return new LastFrame();
		}
		return new NormalFrame(no);
	}

	public int getFirstScore() {
		if (!(state instanceof Ready)) {
			return state.getFirstScore();
		}
		return 0;
	}
}
