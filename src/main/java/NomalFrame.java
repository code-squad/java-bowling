
public class NomalFrame extends Frame {

	public NomalFrame(int score) {
		count++;
		firstTryScore = score;
		isStrike(firstTryScore);
	}

	public NomalFrame() {
	}

	public boolean isStrike(int firstTryScore) {
		if (firstTryScore == 10) {
			strike = true;
		}
		return strike;
	}

	public boolean isSpare(int firstTryScore, int secondTryScore) {
		return (firstTryScore + secondTryScore) == 10;
	}

	public void secondScoreInsert(int score) {
		count++;
		secondTryScore = score;
		ispare();
	}

	private boolean ispare() {
		if (firstTryScore + secondTryScore == 10) {
			return spare = true;
		}
		return spare;
	}
}
