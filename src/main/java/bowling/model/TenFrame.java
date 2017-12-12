package bowling.model;

import bowling.model.state.Ready;
import bowling.model.state.State;

public class TenFrame extends Frame {
	private State state;

	public TenFrame() {
		state = new Ready(10);
	}
	
	public Frame play(int pin) {
		state = state.play(pin);
		return this;
	}

	public boolean isEnd() {
		return state.isEnd();
	}

	public String getStatus() {
		return state.getStatus();
	}

	public int getScore() {
		if (!isEnd()) {
			return -1;
		}
		return state.getScore().getScore();
	}

	protected int calculate(Score beforeScore) {
		Score score = state.calculate(beforeScore);
		if (score.isFinish()) {
			return score.getScore();
		}
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenFrame other = (TenFrame) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TenFrame [state=" + state + "]";
	}
}