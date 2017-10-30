package bowling.pins;

import bowling.exception.BowlingGameException;

public class Pin {

	private int pins;

	public Pin() {
		this.pins = 10;
	}

	public int getPins() {
		return pins;
	}

	public int hitPins(int bowlScore) throws BowlingGameException {
		this.pins = this.pins - bowlScore;
		if (this.pins < 0) {
			throw new BowlingGameException("쓰러트린 볼링 핀의 수가 음수가 될 수 없습니다.");
		}
		return this.pins;
	}

	public Pin hitPins(Pin pin) {
		return null;
	}

}
