package bowling;

public class Score {
	private int score;
	private int leftNo;

	Score(int score, int leftNo) {
		this.score = score;
		this.leftNo = leftNo;
	}
	
	public int getScore() {
		return this.score;
	}

	public void bowl(int pinsPerTry) {
		this.score += pinsPerTry;
		this.leftNo--;
	}

	public boolean isEnded() {
		return this.leftNo == 0;
	}
}