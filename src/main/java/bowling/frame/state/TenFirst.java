package bowling.frame.state;

import bowling.frame.CannotCalculateException;

public class TenFirst extends Running {
	private int first;

	public TenFirst(int countOfPin) {
		this.first = countOfPin;
	}

	@Override
	public State bowl(int countOfPin) {
		return new TenSecond(this.first, countOfPin);
	}
	
	public Score cacluateAdditionalScore(Score score) {
		score = score.bowl(this.first);
		if (score.isReady()) {
			return score;
		}
		throw new CannotCalculateException();
	}
	
	@Override
	public String getDesc() {
		return this.first + " | ";
	}
}
