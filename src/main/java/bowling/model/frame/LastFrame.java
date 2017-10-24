package bowling.model.frame;

import bowling.model.state.EndState;
import bowling.model.state.State;
import bowling.model.state.last.LastReady;
import bowling.model.state.last.LastSecond;

public class LastFrame extends Frame {
	State state;

	public LastFrame() {
		no = 10;
		this.state = new LastReady();
		isDone = false;
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

	@Override
	public int getScore() {
		if (state.isEnd()) {
			return ((EndState) state).getSumScore();
		}
		return 0;
	}

	@Override
	public String getSumScore() {
		if (isDone) {
			return Integer.toString(((EndState) state).getSumScore());
		}
		return "   ";
	}

	@Override
	public boolean calculate(int beforeSum) {
		if (isDone()) {
			return false;
		}
		if (state.isEnd()) {
			isDone = ((EndState) state).calculateSumScore(beforeSum);
			return true;
		}
		return false;
	}

	@Override
	boolean calSpare(State beforeState, int beforeSum) {
		if (!(state instanceof LastReady)) {
			beforeSum += state.getFirstScore();
			return ((EndState) beforeState).calculateSumScore(beforeSum);
		}
		return false;
	}

	@Override
	boolean calStrike(State beforeState, int beforeSum) {
		if (state instanceof LastSecond) {
			beforeSum += ((EndState) state).getScore();
			return ((EndState) beforeState).calculateSumScore(beforeSum);
		}
		return false;
	}

	@Override
	public boolean isEndState() {
		return state.isEnd();
	}
}
