package domain.frame;

import domain.PlayStatus;

public class FinalFrame extends Frame {
	public FinalFrame(int firstPitch) {
		super(Frame.MAX_FRAME_NUMBER, firstPitch);
	}
	
	@Override
	public boolean isComplete() {
		if(getPitches().has(3)) {
			return true;
		}
		
		if(getPitches().has(2)) {
			PlayStatus secondPitchStatus = getPitches().get(2).getStatus();
			return secondPitchStatus == PlayStatus.OPEN
					 || secondPitchStatus == PlayStatus.STRIKE;
		}

		return false;
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return this;
		}
		
		return super.bowl(pinCount);
	}
}