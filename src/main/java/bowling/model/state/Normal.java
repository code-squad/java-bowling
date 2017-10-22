package bowling.model.state;

public class Normal extends EndState {
	int firstScore;
	int secondScore;

	public Normal(int firstScore, int secondScore) {
		if (firstScore + secondScore >= 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
}
