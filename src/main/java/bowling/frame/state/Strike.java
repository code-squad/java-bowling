package bowling.frame.state;

class Strike extends Finished {
	@Override
	int countOfFramePins() {
		return 10;
	}

	@Override
	int noOfNextSum() {
		return 2;
	}

	public Score cacluateAdditionalScore(Score score) {
		if (score.isReady()) {
			return score;
		}
		return score.bowl(10);
	}
	
	@Override
	public String getDesc() {
		return "X";
	}
}
