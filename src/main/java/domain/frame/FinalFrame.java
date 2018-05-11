package domain.frame;

import domain.status.Spare;
import domain.status.Strike;

public class FinalFrame extends Frame {
	public FinalFrame(int firstPin) {
		super(MAX_FRAME_NUMBER, firstPin);
	}
	
	@Override
	public boolean isComplete() {
		if (getPins().size() > 2) {
			return true;
		}
		
		return getStatus().isComplete() && !getStatus().ofInstance(Spare.class, Strike.class);
		
	}
	
	@Override
	public boolean getScoreFlag() {
		return isComplete();
	}

	@Override
	public int getScore() {
		if (!getScoreFlag()) {
			throw new IllegalStateException(getFrameNumber() + "프레임은 점수를 구할 수 없는 상태입니다.");
		}
		return getPins().sum();
	}
}