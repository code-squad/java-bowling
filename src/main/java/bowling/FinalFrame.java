package bowling;


public class FinalFrame extends Frame {
	private LastScore lastScore;

	public FinalFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	protected boolean isNotEnd() {
		if (isFrameEmpty())
			return true;
		if(lastScore == null)
			return true;
		return !lastScore.isFinal();
	}
	@Override
	protected LastScore setLastChance(){
		if (getStatus() != Status.READY && lastScore == null){
			lastScore = new LastScore(getStatus().getLastChance());
		}
		return lastScore;
	}
	@Override
	protected void countChance(LastScore lastScore){
		if(lastScore != null){
			lastScore.useChance();
		}
	}
	

	@Override
	protected String makeFinalStrikeResult() {
		return getFirstPin() + " | " + getBonusPin();
	}

	@Override
	protected String makeFinalSpareResult() {
		return getBonusPin() + "";
	}

	@Override
	protected boolean checkFrameException(int score) {
		if (score > 10)
			return true;
		if ((getStatus() == Status.SPARE && getStatus() == Status.STRIKE) && score > 10)
			return true;
		return false;
	}

	@Override
	public boolean isGameEnd() {
		if (lastScore == null)
			return false;
		if (lastScore.isGameEnd())
			return true;
		return false;
	}

	@Override
	protected boolean isFinalStrikeOrSpare() {
		return getFrameSize() == 3;
	}

	@Override
	protected Score addNextScore(Score frameScore, int frameNum) {
		if(frameNum < 9)
			return super.addNextScore(frameScore, frameNum);
		frameScore = new Score(0, 3);
		for (Integer score : getFrame()){
			frameScore.bowl(score);
		}
		if(frameScore.isEnded())
			return frameScore;
		return null;

	}

	@Override
	protected LastScore getLastChance() {
		return lastScore;
	}


}