package bowling;

import java.util.ArrayList;

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
			lastScore = new LastScore(getStatus().getLastChance() + 1);
		if (lastScore != null) {
			lastScore.useChance();
			return lastScore.isFinal();
		}
		return true;
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
	public boolean isGameNotEnd() {
		if (lastScore == null)
			return true;
		if (lastScore.isGameNotEnd())
			return true;
		return false;
	}

	@Override
	protected Score calcSparePin(Score frameScore) {
		return addThirdScore(frameScore);
	}

	@Override
	protected void calcStrikePin(Score frameScore) {
		addSecondScore(frameScore);
		addThirdScore(frameScore);
	}

	@Override
	protected boolean isFinalStrikeOrSpare() {
		return getFrameSize() == 3;
	}

	@Override
	protected Score addNextScore(Score frameScore, int frameNum) {
		if(frameNum == 8)
			return super.addNextScore(frameScore, frameNum);
		frameScore = new Score(0, createBonusNum());
		for (Integer score : getFrame()) {
			frameScore.bowl(score);
		}
		return frameScore;

	}


}