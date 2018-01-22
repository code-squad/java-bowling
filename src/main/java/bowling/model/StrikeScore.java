package bowling.model;

public class StrikeScore implements Score {

	public StrikeScore() {
	}

	@Override
	public int currentScore() {
		return 10;
	}

	@Override
	public String toString() {
		return String.format("  X  ");
	}

}
