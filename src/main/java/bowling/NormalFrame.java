package bowling;

import static bowling.Status.*;

public class NormalFrame extends Frame {

	public NormalFrame() {
		super();
	}
	
	public boolean isNotEnd() {
		return (getStatus() == null) || (getStatus() == Status.READY);
	}
	
	public String changeFormat() {
		String result = "\t" + frame.get(0);
		if (getStatus() == STRIKE)
			result = "\t" + "X" + "\t|";
		if (getStatus() == SPARE)
			result = " | /" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) == 0)
			result = " | -" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) != 0)
			result = " | " + frame.get(1) + "\t|";
		return result;

	}

}
