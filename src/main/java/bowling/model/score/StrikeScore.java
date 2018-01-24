package bowling.model.score;

public class StrikeScore implements Score {

	public StrikeScore() {
	}

	@Override
	public int currentScore() {
		return 10;
	}

	@Override
	public int firstScore() {
		return 10;
	}

	public int getScore(Score next, Score nextNext) {
		if (next == null)
			throw new IllegalStateException();

		if (!(next instanceof StrikeScore) && !(next instanceof FirstScore))
			return this.currentScore() + next.currentScore();

		if (nextNext == null)
			throw new IllegalStateException();

		if (nextNext instanceof StrikeScore)
			return 30;

		return 20;
	}

}
