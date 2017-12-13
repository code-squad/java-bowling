package bowling.model;

import bowling.model.state.State;

public abstract class AbstractFrame implements Frame {
	private State state;
	
	public AbstractFrame(State state) {
		this.state = state;
	}

	@Override
	public boolean isEnd() {
		return state.isEnd();
	}

	@Override
	public String getStatus() {
		return state.getStatus();
	}

	public void bowl(int pin) {
		state = state.play(pin);
	}
	
	protected Score getStateScore() {
		return state.getScore();
	}

	@Override
	abstract public int getScore();

	@Override
	public int calculate(Score beforeScore) {
		Score score = state.calculate(beforeScore);
		if (score.isFinish()) {
			return score.getScore();
		}
		return additionalCalculate(score);
	}
	
	abstract protected int additionalCalculate(Score beforeScore);

}
