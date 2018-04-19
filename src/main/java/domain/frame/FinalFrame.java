package domain.frame;

import domain.PlayStatus;

public class FinalFrame extends Frame {
	public FinalFrame(int firstPitch) {
		super(Frame.MAX_FRAME_NUMBER, firstPitch);
	}
	
	@Override
	public boolean isComplete() {
		if (getPitches().has(3)) {
			return true;
		}
		
		if (getPitches().has(2)) {
			PlayStatus secondPitchStatus = getPitches().get(2).getStatus();
			return PlayStatus.OPEN.equals(secondPitchStatus)
					 || PlayStatus.STRIKE.equals(secondPitchStatus);
		}

		return false;
	}
	
	@Override
	public boolean canScore() {
		return isComplete();
	}
}