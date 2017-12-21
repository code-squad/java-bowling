package bowling;

import static bowling.Status.*;

public class NormalFrame extends Frame {

	public NormalFrame() {
		super();
	}

	public boolean isNotEnd() {
		return (getStatus() == null) || (getStatus() == Status.READY);
	}

	@Override
	public String changeFormat() {
		String result = "";
		if (isReady()) {
			result = "\t" + frame.get(0) + " | ";
			return result;
		}
		if (isStrike()) {
			result = "\t" + "X" + "\t| ";
			return result;
		}
		if (isSpare()) {
			result += "/" + "\t| ";
			return result;
		}
		if (isMiss()) {
			result += "-" + "\t|";
			return result;
		}
		if (isNormal()) {
			result += frame.get(1) + "\t|";
			return result;
		}
		return result;
	}

	public boolean isSpare() {
		return (frame.size() == 2) && (frame.get(0) + frame.get(1) == 10);
	}

	public boolean isStrike() {
		return (frame.size() == 1) && frame.get(0) == 10;

	}

}
