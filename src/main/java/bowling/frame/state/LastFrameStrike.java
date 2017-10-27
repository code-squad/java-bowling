package bowling.frame.state;

public class LastFrameStrike extends EndState {
	private int firstScore = 10;

	@Override
	public State bowl(int score) {
		return new LastFrameSpare(firstScore, score);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}

	@Override
	public String getChar() {
		return "  X   |";
	}

}
