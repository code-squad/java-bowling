package bowling.frame.state;

public class BonuceChance extends EndState {

	public BonuceChance(int firstScore, int secondScore, int thirdScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
	}

	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public int getFristScore() {
		return firstScore;
	}

	@Override
	public String getChar() {
		return " " + firstScore + "|" + secondScore + "|" + thirdScore;
	}

	public int getEndScore() {
		return firstScore + secondScore + thirdScore;
	}

}
