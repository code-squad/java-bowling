package sangco.bowling.model;

public class NormalFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int gameTotalScore = 0;
	private int frameTotalScore = 0;
	
	
	public NormalFrame(int scoreFirstRoll, int scoreSecondRoll) {
		this.scoreFirstRoll = scoreFirstRoll;
		this.scoreSecondRoll = scoreSecondRoll;
	}

	
	@Override
	public int getFirstRoll() {
		return scoreFirstRoll;
	}


	@Override
	public int getFrameTotalScore() {
		frameTotalScore = scoreFirstRoll + scoreSecondRoll;
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
