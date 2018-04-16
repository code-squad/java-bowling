package domain.frame;

import domain.Pitch;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return createNextFrame(pinCount);
		}

		secondPitch = new Pitch(firstPitch.getRemainPinCount(), pinCount);
		return this;
	}

	@Override
	public boolean isComplete() {
		return firstPitch.isClear() || secondPitch.isClear();
	}

	private Frame createNextFrame(int firstPitch) {
		if(frameNumber < MAX_FRAME_NUMBER - 1) {
			return new NormalFrame(++frameNumber, firstPitch);
		}
		return new FinalFrame(++frameNumber, firstPitch);
	}
}
