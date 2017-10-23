package bowling.frame.state;

public class Score {
	private int score;
	private int left;

	public Score(int score, int left) {
		this.score = score;
		this.left = left;
	}
	
	public void bowl(int countOfPins) {
		this.score+= countOfPins;
		this.left--;
	}

	public int getScore() {
		if (!isReady()) {
			throw new CannotCalculateException();
		}
		return this.score;
	}

	public boolean isReady() {
		return left == 0;
	}
}
