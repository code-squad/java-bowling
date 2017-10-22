package bowling.model.state.last;

import bowling.model.state.EndState;

public class LastThird extends EndState {
	private int firstScore;
	private int secodScore;
	private int thirdScore;

	public LastThird(int firstScore, int secondScore, int thirdScore) {
		if (firstScore + secondScore < 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secodScore = secondScore;
		this.thirdScore = thirdScore;
	}

}
