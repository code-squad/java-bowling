package bowling.frame.state;

class Miss extends Finished {
	private int first;
	private int second;

	Miss(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	Score getScore() {
		return new Score(this.first + this.second, 0);
	}
}
