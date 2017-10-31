package bowling.score;

import bowling.frame.state.State;

public class Score {

	private int score;

	public Score(State state) {
		this.score = state.getEachFinalFrameScore();
	}

	public static Score calculate(State state) {
		return new Score(state);
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
		if (score != other.score)
			return false;
		return true;
	}

}
