package sangco.bowling.model.frame;

public class StrikeFrame implements Frame {

	public static final int frameTotalScore = 10;
	private int gameTotalScore = 0;
	
	@Override
	public int getFirstRoll() {
		return frameTotalScore;
	}

	@Override
	public int getFrameTotalScore() {
		return frameTotalScore;
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public void setGameTotalScore(int totalScore) {
		gameTotalScore = getFrameTotalScore() + totalScore;
	}
}
