package bowling.frame.state;

import bowling.exception.BowlingException;

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
		if (firstScore + secondScore >= 10) {
			return new BonuceChance(firstScore, secondScore, score);
		}
		throw new BowlingException();
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
