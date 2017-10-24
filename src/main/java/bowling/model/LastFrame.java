package bowling.model;

import bowling.model.state.EndState;
import bowling.model.state.State;
import bowling.model.state.last.LastReady;
import bowling.model.state.last.LastSecond;

public class LastFrame extends Frame {
	State state;
	int no;
	boolean isDone;

	public LastFrame() {
		this.no = 10;
		this.state = new LastReady();
		this.isDone = false;
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
	public boolean isDone() {
		return isDone;
	}

	@Override
	public void calculate(int beforeSum) {
		if (isDone()) {
			return;
		}
		if (state.isEnd()) {
			isDone = ((EndState) state).calculateSumScore(beforeSum);
		}
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
}
