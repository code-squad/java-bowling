package bowling.model;

import bowling.model.state.EndState;
import bowling.model.state.State;
import bowling.model.state.last.LastReady;

public class LastFrame extends Frame {
	State state;
	int no;

	public LastFrame() {
		this.no = 10;
		state = new LastReady();
	}

	@Override
	public Frame bowl(int knockedPins) {
		state = state.bowl(knockedPins);
		if (state.isEnd()) {
			return this;
		}
		return this;
	}

	@Override
	public int getScore() {
		if (state.isEnd()) {
			return ((EndState) state).getScore();
		}
		return 0;
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
	public int getFirstScore() {
		if (!(state instanceof LastReady)) {
			return state.getFirstScore();
		}
		return 0;
	}
}
