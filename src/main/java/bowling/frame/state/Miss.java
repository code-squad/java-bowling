package bowling.frame.state;

class Miss extends Finished {
	private int first;
	private int second;

	Miss(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	int countOfFramePins() {
		return this.first + this.second;
	}

	@Override
	int noOfNextSum() {
		return 0;
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
	public String getDesc() {
		return this.first + " | " + this.second;
	}
}
