package bowling.model;

import bowling.model.state.EndState;
import bowling.model.state.Normal;
import bowling.model.state.Ready;
import bowling.model.state.Spare;
import bowling.model.state.State;
import bowling.model.state.Strike;

public class NormalFrame extends Frame {
	Frame nextFrame;
	State state;
	int no;
	boolean isDone;

	public NormalFrame(int number) {
		this.state = new Ready();
		this.no = number;
		this.isDone = false;
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

	private Frame createFrame(int no) {
		if (no == 10) {
			return new LastFrame();
		}
		return new NormalFrame(no);
	}

	@Override
	public int getFirstScore() {
		if (!(state instanceof Ready)) {
			return state.getFirstScore();
		}
		return 0;
	}

	@Override
	public int getScore() {
		if (nextFrame.isDone()) {
			return nextFrame.getScore();
		}
		return ((EndState) state).getSumScore();
	}

	@Override
	public String getSumScore() {
		if (isDone()) {
			return Integer.toString(getScore());
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
			int nowSumScore = ((EndState) state).getSumScore();
			nextFrame.calculate(nowSumScore);
			return;
		}
		if (state.isEnd()) {
			isDone = checkState(beforeSum);
			int nowSumScore = ((EndState) state).getSumScore();
			nextFrame.calculate(nowSumScore);
		}
	}

	private boolean checkState(int beforeSum) {
		if (state instanceof Normal) {
			return ((Normal) state).calculateSumScore(beforeSum);
		}
		if (state instanceof Spare) {
			return nextFrame.calSpare(state, beforeSum);
		}
		if (state instanceof Strike) {
			return nextFrame.calStrike(state, beforeSum);
		}
		return false;
	}

	@Override
	boolean calStrike(State beforeState, int beforeSum) {
		if (state instanceof Strike) {
			beforeSum += ((EndState) state).getScore();
			return nextFrame.calSpare(beforeState, beforeSum);
		}
		if (state.isEnd()) {
			beforeSum += ((EndState) state).getScore();
			return ((EndState) beforeState).calculateSumScore(beforeSum);
		}
		return false;
	}

	@Override
	boolean calSpare(State beforeState, int beforeSum) {
		if (!(state instanceof Ready)) {
			beforeSum += state.getFirstScore();
			return ((EndState) beforeState).calculateSumScore(beforeSum);
		}
		return false;
	}
}
