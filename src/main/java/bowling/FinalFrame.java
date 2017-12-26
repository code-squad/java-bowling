package bowling;

import static bowling.Status.MISSORNORMAL;

public class FinalFrame extends Frame {
	public FinalFrame() {
		super();
	}

	@Override
	protected boolean isNotEnd() {
		return doNotExtraShot() || isFirstShotStrike();
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
	
	private boolean isFirstShotStrike() {
		return frame.get(0) == 10 && frame.size() < 3;
	}
	
	private boolean doNotExtraShot() {
		return getStatus() != Status.MISSORNORMAL && getStatus() != null;
	}
	
	private String checkStrikeOrSpare() {
		if (frame.get(frame.size() - 1) != 10) {
			return "/";
		}
		return "X";
	}
}