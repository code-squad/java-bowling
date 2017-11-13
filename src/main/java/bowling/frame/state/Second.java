package bowling.frame.state;

public class Second extends End {

	private int firstScore;
	private int secondScore;

	public Second(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
}
