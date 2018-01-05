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
		if (getStatus() != Status.READY && lastScore == null)
			lastScore = new LastScore(getStatus().getLastChance());
		if(lastScore != null){
			lastScore.useChance();
			return lastScore.isFinal();
		}
		return true;
	}

	protected boolean isSpare() {
		if (getFirstPin() != null && getSecondPin() != null)
			return isFinalSpareStrike() && (getFirstPin() + getSecondPin() == 10);
		return false;
	}

	protected boolean isStrike() {
		if (getFirstPin() != null)
			return isFinalSpareStrike() && (getFirstPin() == 10);
		return false;
	}

	@Override
	protected String makeFinalStrikeResult() {
		return getFirstPin() + " | " + getSecondPin();
	}

	@Override
	protected String makeFinalSpareResult() {
		return getSecondPin() + "";
	}

	@Override
	protected boolean checkFrameException(int score) {
		if(score > 10)
			return true;
		if((getStatus() == Status.SPARE && getStatus() == Status.STRIKE) && score > 10)
			return true;
		return false;
	}

	@Override
	public boolean isGameNotEnd() {
		if(lastScore == null)
			return true;
		if(lastScore.isGameNotEnd())
			return true;
		return false;
	}

	@Override
	protected Integer calcSparePin(int frameNum) {
		if(getBonusPin() != null)
			return getBonusPin();
		return null;
	}
	
	@Override
	protected Integer calcStrikePin(int frameNum) {
		if(getSecondPin() != null && getBonusPin() != null)
			return getSecondPin() + getBonusPin();
		return null;
	}


}