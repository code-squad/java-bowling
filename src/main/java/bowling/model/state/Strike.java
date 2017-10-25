package bowling.model.state;

public class Strike extends EndState {
	private int sumScore;
	private int count;

	public Strike() {
		sumScore = 10;
		count = 2;
	}

	@Override
	public String getKnockedPins() {
		return "X";
	}

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public int getFirstScore() {
		return 10;
	}

	@Override
	public boolean calculateSumScore(int beforeSum) {
		sumScore += beforeSum;
		return true;
	}

	@Override
	public int getSumScore() {
		return sumScore;
	}
}
