package bowling.frame.state;

public class LastSecond extends Finish {

	private int firstScore;
	private int secondScore;

	public LastSecond(int firstScore, int bowls) {
		this.firstScore = firstScore;
		this.secondScore = bowls;
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "|" + secondScore + "  |";
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
