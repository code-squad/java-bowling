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


	protected boolean isSpare() {
		return (normalFrame.size() == 2) && (normalFrame.get(0) + normalFrame.get(1) == 10);
	}

	protected boolean isStrike() {
		return (normalFrame.size() == 1) && normalFrame.get(0) == 10;

	}

	@Override
	protected String makeFinalStrikeResult() {
		return "";
	}

	@Override
	protected String makeFinalSpareResult() {
		return "";
	}

	@Override
	protected boolean isLeftPinExist(int score) {
		return (normalFrame.get(0) + score > 10);
	}

}
