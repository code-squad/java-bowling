package bowling.model.state;

public class Normal extends EndState {
	private int firstScore;
	private int secondScore;

	public Normal(int firstScore, int secondScore) {
		if (firstScore + secondScore >= 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	
	@Override
	public String getKnockedPins() {
		return Integer.toString(firstScore) + "|" + Integer.toString(secondScore);
	}
	
	@Override
	public int getScore() {
		return firstScore + secondScore;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}
}
