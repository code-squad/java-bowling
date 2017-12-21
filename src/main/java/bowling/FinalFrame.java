package bowling;

import static bowling.Status.STRIKE;
import static bowling.Status.SPARE;
import static bowling.Status.MISSORNORMAL;
import static bowling.Status.FIRSTSHOT;
import static bowling.Status.READY;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	
	ArrayList<Integer> finalFrame = new ArrayList<>();

	public FinalFrame() {
		super();
	}
//Status.valueOf(isPinClear(), frame.size());
	@Override
	public boolean isNotEnd() {
		if (getStatus() == Status.MISSORNORMAL) {
			return false;
		}
		if (getStatus() == Status.STRIKE || getStatus() == Status.SPARE) {
			return true;
		}
		if (getStatus() == Status.READY || getStatus() == Status.FIRSTSHOT) {
			return true;
		}
		return false;
	}

	@Override
	public String changeFormat() {
		String strScore = "\t" + frame.get(0);
		if (getStatus() == STRIKE)
			strScore = "\t" + "X" + "|";
		if (getStatus() == SPARE)
			strScore = " | /" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) == 0)
			strScore = " | -" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) != 0)
			strScore = " | " + frame.get(1) + "\t|";
		return strScore;
	}
}