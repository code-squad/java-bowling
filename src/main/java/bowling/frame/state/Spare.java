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

	@Override
	public int[] getScore() {
		int[] results = new int[2];
		results[0] = firstScore;
		results[1] = secondScore;
		return results;
	}

}