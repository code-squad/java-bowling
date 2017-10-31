package bowling.frame.state;

public class Second extends Finish {

	private int firstScore;
	private int secondScore;

	public Second(int firstScore, int bowls) {
		this.firstScore = firstScore;
		secondScore = bowls;
	}

	@Override
	public String getChar() {
		if (secondScore == 0) {
			return "  " + firstScore + "|-  |";
		}
		return "  " + firstScore + "|" + secondScore + "  |";
	}

}
