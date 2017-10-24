package bowling.frame.state;

public class Second extends EndState {

	public Second(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|" + secondScore + " |";
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}

}
