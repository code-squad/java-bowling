package bowling.frame.state;

public class LastFrameFirst implements State {

	private int firstScore;

	public LastFrameFirst(int score) {
		firstScore = score;
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
	public int getSecondScore() {
		return 0;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score == 10) {
			return new LastFrameSpare(firstScore, score);
		}
		return new Second(firstScore, score);
	}

	@Override
	public String getChar() {
		return " " + firstScore + "   |";
	}

	@Override
	public int getEndScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
