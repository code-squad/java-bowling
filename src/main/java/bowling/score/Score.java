package bowling.score;

public class Score {

	private int score;

	private Score(int score) {
		this.score = score;
	}

	public static Score inputScore(int score) {
		return new Score(score);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		return score == other.score;
	}

}
