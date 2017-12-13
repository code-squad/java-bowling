package bowling.model;

import bowling.model.state.Ready;

public class TenFrame extends AbstractFrame {

	public TenFrame() {
		super(new Ready(10));
	}
	
	public Frame play(int pin) {
		bowl(pin);
		return this;
	}

	public int getScore() {
		if (!isEnd()) {
			return -1;
		}
		return getStateScore().getScore();
	}

	public int additionalCalculate(Score beforeScore) {
		return -1;
	}
}