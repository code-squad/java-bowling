package bowling.frame.state;

public class TenSecond implements State {
	private int first;
	private int second;

	public TenSecond(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public State bowl(int countOfPin) {
		if (isFinish()) {
			throw new UnsupportedOperationException();
		}
		return new TenThird(this.first, this.second, countOfPin);
	}

	@Override
	public boolean isFinish() {
		return first + second < 10;
	}

	@Override
	public Score getScore() {
		if (isFinish()) {
			return new Score(this.first + this.second, 0);
		}
		
		return new Score(this.first + this.second, 1);
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
