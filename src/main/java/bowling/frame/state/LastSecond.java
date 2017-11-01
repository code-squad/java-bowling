package bowling.frame.state;

public class LastSecond extends Finish {

	private int firstScore;
	private int secondScore;

	public LastSecond(int firstScore, int bowls) {
		this.firstScore = firstScore;
		secondScore = bowls;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|" + secondScore + "  |";
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}
}
