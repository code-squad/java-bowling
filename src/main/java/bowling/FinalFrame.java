package bowling;

import static bowling.Status.MISSORNORMAL;
import static bowling.Status.SPARE;
import static bowling.Status.STRIKE;
import static bowling.Status.READY;

public class FinalFrame extends Frame {
	private Status status = null;

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

	private void setFrameStatus() {
		status = getStatus();
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

	@Override
	public boolean isNotEnd() {
		if (frame.size() == 0)
			return true;
		if (frameStatus() != null && !isStatusFix())
			setFrameStatus();
		if (Status.hasLastChance(status) != 0)
			return true;
		return false;
	}

	@Override
	public String changeFormat() {
		String strScore = "";
		if (status == STRIKE && frame.size() == 3) {
			strScore = "\t" + "X" + "|" + frame.get(1) + "|" + frame.get(2);
			return strScore;
		}
		if (status == SPARE && frame.size() == 3) {
			strScore = "\t" + frame.get(0) + " | /" + "|" + +frame.get(2);
			return strScore;
		}
		if (status == MISSORNORMAL && frame.get(1) == 0)
			strScore = "\t" + frame.get(0) + " a| -" + "\t|";
		if (status == MISSORNORMAL && frame.get(1) != 0)
			strScore = "\t" + frame.get(0) + " b| " + frame.get(1) + "\t|";
		return strScore;

	}

}
