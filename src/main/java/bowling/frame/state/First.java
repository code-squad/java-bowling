package bowling.frame.state;

public class First implements State {

	private int firstScore;

	public First(int score) {
		this.firstScore = score;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new Spare(firstScore, score);
		}
		return new Second(firstScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		return stringBuilder.toString();
	}
}
