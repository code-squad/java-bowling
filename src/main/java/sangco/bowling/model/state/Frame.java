package sangco.bowling.model.state;

public abstract class Frame {
	protected int frameNumber = 0;
	protected boolean totalSetOrNot = false;
	protected int scoreFirstRoll = 0;
	protected int scoreSecondRoll = 0;
	protected int gameTotalScore = 0;
	protected Frame nextFrame;
	
	public abstract int setGameTotalScore(int totalScore);
	
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	protected int getScoreFirstRoll() {
		return scoreFirstRoll;
	}

	protected int getFrameScore() {
		return scoreFirstRoll + scoreSecondRoll;
	}

	public boolean getTotalSetOrNot() {
		return totalSetOrNot;
	}

	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}

	protected int getTwoFrameNextFirstScore() {
		return nextFrame.getScoreFirstRoll();
	}
}