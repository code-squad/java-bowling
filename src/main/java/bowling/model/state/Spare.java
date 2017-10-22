package bowling.model.state;

public class Spare extends EndState {
	int firstScore;
	int secondScore;

	public Spare(int firstScore, int secondScore) {
		if (firstScore + secondScore != 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

}
