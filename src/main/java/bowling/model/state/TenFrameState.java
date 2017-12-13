package bowling.model.state;

import bowling.model.Score;

public class TenFrameState implements State {
	TenFramePins pins;
	
	public TenFrameState(int pin) {
		pins = new TenFramePins(pin);
	}

	@Override
	public State play(int pin) {
		pins.addPin(pin);
		return this;
	}

	@Override
	public String getStatus() {
		if (pins.hasSecondPin() && !pins.hasThirdPin()) {
			return pins.makeSecondPinStatus();
		} else if (pins.hasThirdPin()) {
			return pins.makeThirdStatus(pins.makeSecondPinStatus());
		}
		return pins.makeFirstPinStatus();
	}
	
	@Override
	public Score getScore() {
		return pins.getTenScore();
	}
	
	@Override
	public Score calculate(Score beforeScore) {
		return pins.calculate(beforeScore);
	}
	
	@Override
	public boolean isEnd() {
		return pins.isEnd();
	}

	@Override
	public String toString() {
		return "TenFrameState [pins=" + pins + "]";
	}
}