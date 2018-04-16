package domain.frame;

import domain.Pitch;

public class FinalFrame extends Frame {
	private Pitch thirdPitch;
	public FinalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
	}
	
	@Override
	public Frame bowl(int pinCount) {
		if(!isComplete()) {
			if(firstPitch.isClear() || secondPitch.isClear()) {
				thirdPitch = new Pitch(DEFAULT_START_PIN_COUNT , pinCount);
			} else {
				secondPitch = new Pitch(firstPitch.getRemainPinCount(), pinCount);
			}
		}


		return this;
	}

	@Override
	public boolean isComplete() {

		return hasThirdPitch()
				|| (!hasThirdPitch() && firstPitch.isClear())
				|| (!hasThirdPitch() && secondPitch.isClear());
	}

	public boolean hasThirdPitch() {
		return thirdPitch != null;
	}

}