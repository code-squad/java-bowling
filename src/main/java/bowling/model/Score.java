package bowling.model;

public class Score {
	private int score;
	private int remainingNo;
	
	public int getScore() {
		if(isFinish()) {
			return score;
		}
		return -1;
	}

	public Score(int score, int remainingNo) {
		this.score = score;
		this.remainingNo = remainingNo;
	}

	public Score addScore(int falledPins) {
		return new Score(score + falledPins, remainingNo -1);
	}

	public boolean isFinish() {
		return remainingNo == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + remainingNo;
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (remainingNo != other.remainingNo)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", remainingNo=" + remainingNo + "]";
	}
}