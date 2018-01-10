package bowling;


public class Score {
	private int frameScore;
	private int leftNum;

	Score(int score, int leftNum) {
		this.frameScore = score;
		this.leftNum = leftNum;
	}

	void bowl(int score) {
		this.frameScore += score;
		this.leftNum--;
	}
	
	public int getLeftNum(){
		return leftNum;
	}

	public int getFrameScore() {
		return frameScore;
	}

	boolean isEnded() {
		return this.leftNum == 0;
	}
}