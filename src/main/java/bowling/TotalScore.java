package bowling;

public class TotalScore {

	private int score;
	private int left;

	public TotalScore(int score, int left) {
		this.score = score;
		this.left = left;
	}

	public TotalScore addRoll(int countOfPins) {
		return new TotalScore(score += countOfPins, left - 1);
	}

	public int getScore() {
		if (!canCalculateScore()) {
			throw new CannotCalculateException();
			// try catch 해줘야 한다.
		}
		return this.score;
	}

	public boolean canCalculateScore() {
		return left == 0;
	}

}
