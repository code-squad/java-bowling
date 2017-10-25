package bowling.model.frame;

import bowling.model.state.EndState;
import bowling.model.state.Normal;
import bowling.model.state.Ready;
import bowling.model.state.Spare;
import bowling.model.state.State;
import bowling.model.state.Strike;

public class NormalFrame extends Frame {
	private Frame nextFrame;
	private State state;

	public NormalFrame(int no) {
		super(no);
		this.state = new Ready();
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
	public boolean calculate(int sumScore) {
		if (isDone()) {
			int nowSumScore = ((EndState) state).getSumScore();
			return nextFrame.calculate(nowSumScore);
		}
		if (state.isEnd()) {
			isDone = checkState(sumScore);
		}
		return isDone();
	}

	private boolean checkState(int sumScore) {
		if (state instanceof Normal) {
			return ((Normal) state).calculateSumScore(sumScore);
		}
		if (state instanceof Spare) {
			return nextFrame.calSpare(state, sumScore);
		}
		if (state instanceof Strike) {
			return nextFrame.calStrike(state, sumScore);
		}
		return false;
	}

	@Override
	protected boolean calStrike(State beforeState, int sumScore) {
		if (state instanceof Strike) {
			sumScore += ((EndState) state).getScore();
			return nextFrame.calSpare(beforeState, sumScore);
		}
		if (state.isEnd()) {
			sumScore += ((EndState) state).getScore();
			return ((EndState) beforeState).calculateSumScore(sumScore);
		}
		return false;
	}

	@Override
	protected boolean calSpare(State beforeState, int sumScore) {
		if (!(state instanceof Ready)) {
			sumScore += state.getFirstScore();
			return ((EndState) beforeState).calculateSumScore(sumScore);
		}
		return false;
	}

	@Override
	public boolean isEndState() {
		return state.isEnd();
	}
}
