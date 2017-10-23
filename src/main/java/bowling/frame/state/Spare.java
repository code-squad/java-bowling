package bowling.frame.state;

class Spare extends Finished {
	private int first;
	private int second;

	Spare(int first, int second) {
		if (first + second != 10) {
			throw new IllegalArgumentException();
		}
		
		this.first = first;
		this.second = second;
	}

	public Score cacluateAdditionalScore(Score score) {
		score = score.bowl(this.first);
		if (score.isReady()) {
			return score;
		}
		score = score.bowl(this.second);
		return score;
	}

	@Override
	int countOfFramePins() {
		return 10;
	}

	@Override
	int noOfNextSum() {
		return 1;
	}
}
