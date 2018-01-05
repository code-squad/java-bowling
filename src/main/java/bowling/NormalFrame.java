package bowling;


public class NormalFrame extends Frame {

	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	protected boolean isNotEnd() {
		return (getStatus() == null) || (getStatus() == Status.READY);
	}

	protected boolean isSpare() {
		if (getFirstPin() != null && getSecondPin() != null)
			return (getFirstPin() + getSecondPin() == 10);
		return false;
	}

	protected boolean isStrike() {
		if (getFirstPin() != null)
			return getFirstPin() == 10;
		return false;

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
	protected boolean checkFrameException(int score) {
		if (getFirstPin() != null && getFirstPin() + score > 10)
			return true;
		return false;
	}

	@Override
	public boolean isGameNotEnd() {
		return true;
	}

	@Override
	protected Integer calcSparePin(int frameNum) {
		if (getSparePin(frameNum) != null)
			return getSparePin(frameNum);
		return null;
	}

	@Override
	protected Integer calcStrikePin(int frameNum) {
		if (getStrikePin(frameNum) != null)
				return getStrikePin(frameNum);
			return null;
	}




}
