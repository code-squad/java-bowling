package domain.frame;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
	}
	
	public NormalFrame(int firstPitch) {
		super(MIN_FRAME_NUMBER, firstPitch);
	}
	
	@Override
	public boolean isComplete() {
		return getFirstPitch().isClear() || getSecondPitch() != null;
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return createNextFrame(pinCount);
		}

		return super.bowl(pinCount);
	}
}
