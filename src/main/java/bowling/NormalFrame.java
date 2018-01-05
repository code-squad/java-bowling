package bowling;


public class NormalFrame extends Frame {

	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	protected boolean isNotEnd() {
		return (getStatus() == null) || (getStatus() == Status.READY);
	}

	protected boolean isSpare() {
		if (getFrameSize() >= 2)
			return (getFirstPin() + getSecondPin() == 10);
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
		if (getFrameSize() >= 1 && getFirstPin() + score > 10)
			return true;
		return false;
	}

	@Override
	public boolean isGameNotEnd() {
		return true;
	}

	@Override
	protected boolean isFinalStrikeOrSpare() {
		return true;
	}





}
