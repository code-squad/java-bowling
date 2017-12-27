public class Score {
	int score;
	private int leftNo;

	Score(int score, int leftNo) {
		this.score = score;
		this.leftNo = leftNo;
	}

	void bowl(int pinsPerTry) {
		this.score += pinsPerTry;
		this.leftNo--;
	}

	boolean isEnded() {
		return this.leftNo == 0;
	}
}
