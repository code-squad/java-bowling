package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;

public class FinalFrame extends Frame {

	ArrayList<Integer> extraFrame = new ArrayList<>();

	public FinalFrame() {
		super();
	}

	@Override
	protected boolean isNotEnd() {
		return (getStatus() != Status.MISSORNORMAL && getStatus() != null) || (frame.get(0) == 10 && frame.size() < 3);
	}
	
	@Override
	protected String changeFormat() {
		String strScore = "" + frame.get(0);
		
		if (isPinClear()) {
			return isFirstOrNot(checkStrikeOrSpare());
		}
		if (getStatus() == MISSORNORMAL || frame.size() == 3) {
			strScore = checkMissOrNormal(frame.get(frame.size() - 1));
		}

		return isFirstOrNot(strScore);
	}
	
	private String checkStrikeOrSpare() {
		if (frame.get(frame.size() - 1) != 10) {
			return "/";
		}
		return "X";
	}
}