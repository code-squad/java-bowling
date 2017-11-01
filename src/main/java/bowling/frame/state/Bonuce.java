package bowling.frame.state;

public class Bonuce extends Running {

	private int firstScore;
	private int secondScore;

	public Bonuce(int firstScore, int bowls) {
		this.firstScore = firstScore;
		secondScore = bowls;
	}

	@Override
	public State bowl(int bowls) {
		return new LastEnd(firstScore, secondScore, bowls);
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|" + secondScore + " |";
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}
}
