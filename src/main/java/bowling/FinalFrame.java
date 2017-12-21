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

	@Override
	protected String changeFormat() {
		String result = "";
		if (isReady())
			return getReadyResult();

		if (isStrike()) {
			result = "\t" + "X" + " | " + finalFrame.get(1) + " | " + finalFrame.get(2);
			return result;
		}
		if (isSpare()) {
			result += "/" + "|" + finalFrame.get(2);
			return result;
		}
		if (isMiss()) {
			result += getMissResult();
			return result;
		}
		if (isNormal()) {
			result += getNormalResult();
			return result;
		}
		return result;
	}

	protected boolean isSpare() {
		return (finalFrame.size() == 3) && (finalFrame.get(0) + finalFrame.get(1) == 10);
	}

	protected boolean isStrike() {
		return (finalFrame.size() == 3) && finalFrame.get(0) == 10;

	}

}