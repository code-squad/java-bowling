package bowling.frame.state;

public class First implements State {

	private int firstScore;

	public First(int score) {
		firstScore = score;
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new Spare(firstScore, score);
		}
		return new Second(firstScore, score);
	}

	@Override
	public String getChar() {
		return "  " + firstScore + "   |";
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}

}
