package sangco.bowling.model.state;

public class NormalFrame extends Frame {
	public NormalFrame() {
		super();
	}

	public NormalFrame(int frameIndex, int scoreFirstRoll, int scoreSecondRoll) {
		super.frameNumber = frameIndex;
		super.scoreFirstRoll = scoreFirstRoll;
		super.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		totalSetOrNot = true;
		gameTotalScore = totalScore + getFrameScore();
		return gameTotalScore;
	}
}