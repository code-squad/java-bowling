package domain.frame;

import domain.PlayStatus;

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
	public boolean canScore() {
		PlayStatus playStatus = getStatus();
		
		if (!isComplete()) {
			return false;
		}
		
		if (!PlayStatus.STRIKE.equals(playStatus)
				&& !PlayStatus.SPARE.equals(playStatus)) {
			return true;
		}
		
		if (PlayStatus.SPARE.equals(playStatus)) {
			return hasNextFrame();
		}
		
		if (hasNextFrame()) {
			return getNextFrame().isComplete();
		}
		
		return false;
	}
}
