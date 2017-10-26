package bowling.frame.state;

public class LastFrameSpare extends EndState {

	public LastFrameSpare(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public State bowl(int score) {
		return new BonuceChance(firstScore, secondScore, score);
	}

	@Override
	public String getChar() {
		return " " + firstScore + "|" + secondScore + "|";
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}
}
