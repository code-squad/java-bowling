package bowling.frame.state;

public class Ready implements State {
	final private int strikeScore = 10;

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public State bowl(int score) {
		if (score == strikeScore) {
			return new Strike();
		}
		return new First(score);
	}

	@Override
	public String getChar() {
		return "      |";
	}

	@Override
	public int getFristScore() {
		return 0;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}

	@Override
	public int getEndScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
