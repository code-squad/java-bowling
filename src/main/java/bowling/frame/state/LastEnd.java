package bowling.frame.state;

public class LastEnd extends Finish {

	private int firstScore;
	private int secondScore;
	private int thirdScore;

	public LastEnd(int firstScore, int secondScore, int bowls) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		thirdScore = bowls;
	}

	@Override
	public String getChar() {
		return " " + firstScore + "|" + secondScore + "|" + thirdScore + " |";
	}

	@Override
	public int getEachFinalFrameScore() {
		return super.getEachFinalFrameScore() + this.thirdScore;
	}
}
