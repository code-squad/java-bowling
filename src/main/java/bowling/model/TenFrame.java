package bowling.model;

public class TenFrame extends Frame {
	private TenFramePins pins;

	public Frame play(int pin) {
		if (checkTryNo(1)) {
			tryOne(pin);
			return this;
		} else if (checkTryNo(2)) {
			tryTwo(pin);
			return this;
		}
		tryThree(pin);
		return this;
	}

	private void tryOne(int pin) {
		addTryNo();
		pins = new TenFramePins(pin);
	}

	private void tryTwo(int pin) {
		pins.checkPinsExceedCount(pin);
		addTryNo();
		pins.addPin(pin);
	}

	private void tryThree(int pin) {
		pins.checkPinsExceedCountThreeTry(pin);
		pins.addThirdPin(pin);
	}

	public boolean isEnd() {
		return pins.isEnd();
	}

	public String getStatus() {
		if (pins.hasSecondPin() && !pins.hasThirdPin()) {
			return pins.makeSecondPinStatus();
		} else if (pins.hasThirdPin()) {
			return pins.makeThirdStatus(pins.makeSecondPinStatus());
		}
		return pins.makeFirstPinStatus();
	}

	public Frame makeNextFrame(int frameSize) {
		return null;
	}
	
	public Frame makeNextFrame() {
		return null;
	}
	public int getScore() {
		//포비 코드
		if (!isEnd()) {
			return -1;
		}
		return pins.getTenScore();
	}

	protected int calculate(Score beforeScore) {
		Score score = pins.calculate(beforeScore);
		if (score.isFinish()) {
			return score.getScore();
		}
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pins == null) ? 0 : pins.hashCode());
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
		if (pins == null) {
			if (other.pins != null)
				return false;
		} else if (!pins.equals(other.pins))
			return false;
		return true;
	}

}