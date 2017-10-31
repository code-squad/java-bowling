package bowling.frame.state;

public class First extends Running {

	private int firstScore;

	public First(int bowls) {
		firstScore = bowls;
	}

	@Override
	public State bowl(int bowls) {
		if (firstScore + bowls == 10) {
			return new Spare(firstScore, bowls);
		}
		return new Second(firstScore, bowls);
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|   |";
	}

}
