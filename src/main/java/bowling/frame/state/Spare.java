package bowling.frame.state;

public class Spare extends EndState {

	public Spare(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|/ |";
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}

}
