package bowling.frame.state;

public class Spare extends Finish {

	private int firstScore;
	private int secondScore;

	public Spare(int firstScore, int bowls) {
		this.firstScore = firstScore;
		secondScore = bowls;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|/  |";
	}

}
