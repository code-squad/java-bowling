package bowling.frame.state;

public class Spare extends Finish {

	private int firstScore;
	private int secondScore;

	public Spare(int firstScore, int bowls) {
		this.firstScore = firstScore;
		this.secondScore = bowls;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|/  |";
	}

	@Override
	public int getEachFinalFrameScore() {
		return 10;
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}
}