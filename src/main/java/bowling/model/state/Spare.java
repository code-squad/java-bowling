package bowling.model.state;

public class Spare extends EndState {
	private int firstScore;
	private int secondScore;

	public Spare(int firstScore, int secondScore) {
		if (firstScore + secondScore != 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	
	@Override
	public String getKnockedPins() {
		return Integer.toString(firstScore) + "|/";
	}
	
	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}
}
