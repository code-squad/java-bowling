
public class NomalFrame extends Frame {

	public NomalFrame(int score) {
		// TODO Auto-generated constructor stub
		count++;
		firstTryScore = score;
		isStrike(firstTryScore);
	}

	public NomalFrame() {
		// TODO Auto-generated constructor stub
	}

	public boolean isStrike(int firstTryScore) {
		// TODO Auto-generated method stub
		if (firstTryScore == 10) {
			strike = true;
		}
		return strike;
	}

	public boolean isSpare(int firstTryScore, int secondTryScore) {
		// TODO Auto-generated method stub
		return (firstTryScore + secondTryScore) == 10;
	}

	public void secondScoreInsert(int score) {
		// TODO Auto-generated method stub
		count++;
		secondTryScore = score;
		ispare();
	}

	private boolean ispare() {
		// TODO Auto-generated method stub
		if (firstTryScore + secondTryScore == 10) {
			return spare = true;
		}
		return spare;
	}
}
