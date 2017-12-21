package bowling;

import java.util.ArrayList;

public class NormalFrame extends Frame {
	ArrayList<Integer> normalFrame = new ArrayList<>();

	public NormalFrame(ArrayList<Integer> frame) {
		super(frame);
		normalFrame = frame;

	}

	protected boolean isNotEnd() {
		return (getStatus() == null) || (getStatus() == Status.READY);
	}

	@Override
	protected String changeFormat() {
		String result = "";
		if (isReady())
			return getReadyResult();

		if (isStrike()) {
			result = "\t" + "X" + "\t| ";
			return result;
		}
		if (isSpare()) {
			result += "/" + "\t|";
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
		return (normalFrame.size() == 2) && (normalFrame.get(0) + normalFrame.get(1) == 10);
	}

	protected boolean isStrike() {
		return (normalFrame.size() == 1) && normalFrame.get(0) == 10;

	}

}
