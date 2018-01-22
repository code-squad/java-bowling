package bowling.model;

public class MissScore implements Score {

	private final int first;
	private final int second;

	public MissScore(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int currentScore() {
		return first + second;
	}

	@Override
	public String toString() {
		return String.format(" %s|%s ", (this.first == 0) ? "-" : this.first, (this.second == 0) ? "-" : this.second);
	}

}
