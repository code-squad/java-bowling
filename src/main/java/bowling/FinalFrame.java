package bowling;

import static bowling.Status.*;

public class FinalFrame extends Frame {
	private Status status = null;
	private static int lastChance;

	public FinalFrame() {
		super();
	}

	private Boolean isStatusFix() {
		if (status == STRIKE)
			return true;
		if (status == SPARE)
			return true;
		return false;
	}

	private Status setFrameStatus() {
		status = getStatus();
		return status;
	}

	private Status frameStatus() {
		if (getStatus() == STRIKE)
			return getStatus();
		if (getStatus() == SPARE)
			return getStatus();
		if (getStatus() == READY)
			return getStatus();
		if (getStatus() == MISSORNORMAL)
			return getStatus();
		return null;
	}

	private Boolean isFinal() {
		if(lastChance-- != 0)
			return true;
		return false;
	}

	@Override
	public boolean isNotEnd() {
		if (frame.isEmpty())
			return true;
		if (frameStatus() != null && !isStatusFix())
			lastChance = setFrameStatus().lastChance;
		if (isFinal())
			return true;
		return false;
	}

	@Override
	public String changeFormat() {
		String result = "";
		if (status == STRIKE && frame.size() == 3) {
			result = "\t" + "X" + "|" + frame.get(1) + "|" + frame.get(2);
			return result;
		}
		if (status == SPARE && frame.size() == 3) {
			result = "\t" + frame.get(0) + " | /" + "|" + +frame.get(2);
			return result;
		}
		if (status == MISSORNORMAL && frame.get(1) == 0)
			result = "\t" + frame.get(0) + " a| -" + "\t|";
		if (status == MISSORNORMAL && frame.get(1) != 0)
			result = "\t" + frame.get(0) + " b| " + frame.get(1) + "\t|";
		return result;

	}

}
