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
		if (frame.get(0) == 10)
			result = "\t" + "X" + "\t|";
		if ((frame.size() == 2 && frame.get(0) + frame.get(1) == 10))
			result = " | /" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) == 0)
			result = " | -" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) != 0)
			result = " | " + frame.get(1) + "\t|";
		return result;

	}

}
