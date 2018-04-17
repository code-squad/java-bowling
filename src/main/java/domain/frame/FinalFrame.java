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
			if(!firstPitch.isClear() && !hasSecondPitch()) {
				secondPitch = new Pitch(firstPitch.getRemainPinCount(), pinCount);
			}else {
				thirdPitch = new Pitch(DEFAULT_START_PIN_COUNT , pinCount);
			}
		}
		
		return this;
	}

	@Override
	public boolean isComplete() {
		if(hasThirdPitch()) {
			return true;
		}
		
		if(hasSecondPitch()) {
			return !secondPitch.isClear();
		}
		
		return false;
	}

	public boolean hasThirdPitch() {
		return thirdPitch != null;
	}
}