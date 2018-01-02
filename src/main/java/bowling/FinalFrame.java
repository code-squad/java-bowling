package bowling;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	private LastScore lastScore;
	ArrayList<Integer> finalFrame = new ArrayList<>();

	public FinalFrame(ArrayList<Integer> frame) {
		super(frame);
		finalFrame = frame;
	}

	@Override
	protected boolean isNotEnd() {
		if (finalFrame.isEmpty())
			return true;
		if (getStatus() != null)
			lastScore = new LastScore(getStatus().getLastChance());
		lastScore.useChance();
		return lastScore.isFinal();
	}

	protected boolean isSpare() {
		return (finalFrame.size() == 3) && (finalFrame.get(0) + finalFrame.get(1) == 10);
	}

	protected boolean isStrike() {
		return (finalFrame.size() == 3) && finalFrame.get(0) == 10;

	}

	@Override
	public void calcSpareScore(Frame pastFrame) {
		if(isSpare())
			frameScore = 10 + finalFrame.get(2);
	}

	@Override
	public void calcPastStrikeScore(Frame pastFrame) {
		if(isStrike()){
			frameScore = 10 + finalFrame.get(1) + finalFrame.get(2);
		}
	}

	@Override
	public void calcPrePastStrikeScore(Frame prePastFrame) {

	}


	@Override
	protected String makeFinalStrikeResult() {
		return finalFrame.get(1) + " | " + finalFrame.get(2);
	}

	@Override
	protected String makeFinalSpareResult() {
		return finalFrame.get(2) + "";
	}

	@Override
	protected boolean checkFrameException() {
		if (getStatus() != Status.STRIKE && finalFrame.size() >= 2 && getStatus() != null)
			return true;
		return false;
	}

}