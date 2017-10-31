package bowling.frame.state;

public class LastFirst extends Running {
	final private int LIMITED_SCORE = 20;
	final private int MINIMUM_SCORE = 10;
	private int firstScore;

	public LastFirst(int bowls) {
		firstScore = bowls;
	}

	@Override
	public State bowl(int bowls) {
		if (firstScore + bowls >= MINIMUM_SCORE && firstScore + bowls <= LIMITED_SCORE) {
			return new Bonuce(firstScore, bowls);
		}
		if (firstScore + bowls > LIMITED_SCORE) {
			throw new IllegalArgumentException();
		}
		return new LastSecond(firstScore, bowls);
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|   |";
	}

}
