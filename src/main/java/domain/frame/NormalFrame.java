package domain.frame;

import domain.Pitch;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
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

		setSecondPitch(new Pitch(getFirstPitch().getRemainPinCount(), pinCount));
		return this;
	}

	private Frame createNextFrame(int firstPitch) {
		if(getFrameNumber() < MAX_FRAME_NUMBER - 1) {
			return new NormalFrame(getFrameNumber() + 1, firstPitch);
		}
		return new FinalFrame(firstPitch);
	}
}
