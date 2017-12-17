package sangco.bowling.model;

public class SpareFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int frameTotal = 0;

	public SpareFrame() {
	}

	public SpareFrame(int scoreFirstRoll, int scoreSecondRoll) {
		this.scoreFirstRoll = scoreFirstRoll;
		this.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public void setFrameTotalScore(int frameTotal) {
		this.frameTotal = frameTotal;
	}

	@Override
	public int getFirstRoll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrameScoreTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGameScoreTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
