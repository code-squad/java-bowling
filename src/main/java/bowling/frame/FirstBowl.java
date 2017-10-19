package bowling.frame;

class FirstBowl implements State {
	private int countOfPin;

	FirstBowl(int countOfPin) {
		this.countOfPin = countOfPin;
	}

	@Override
	public State bowl(int countOfPin) {
		if (this.countOfPin + countOfPin == 10) {
			return new Spare(this.countOfPin, countOfPin);
		}
		
		return new Miss(this.countOfPin, countOfPin);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

}
