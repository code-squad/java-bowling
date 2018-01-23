package bowling.model.score;

public class MissScore implements Score {

	private final int first;
	private final int second;

	public MissScore(int first) {
		this(first, -1);
	}

	public MissScore(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int currentScore() {
		return first + second;
	}
}
