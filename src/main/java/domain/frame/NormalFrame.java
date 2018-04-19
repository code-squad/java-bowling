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
		return getPitches().get(1).isClear() || getPitches().has(2);
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return createNextFrame(pinCount);
		}

		return super.bowl(pinCount);
	}
}
