package bowling.model.state;

import bowling.model.Score;

public class NormalState implements State {
	NormalPins pins;
	
	public NormalState(int pin) {
		pins = new NormalPins(pin);
	}

	@Override
	public State play(int pin) {
		pins.addPin(pin);		
		return this;
	}

	@Override
	public String getStatus() {
		return pins.getStatus();
	}

	@Override
	public Score getScore() {
		return pins.getScore();
	}

	@Override
	public Score calculate(Score beforeScore) {
		return pins.calculate(beforeScore);
	}
	
	@Override
	public boolean isEnd() {
		return pins.isEnd();
	}
}
