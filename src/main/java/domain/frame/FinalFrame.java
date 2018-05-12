package domain.frame;

import domain.Score;
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
	public Score score() {
		if(isComplete()) {
			return Score.ofNone(getPins().sum());
		}
		
		return Score.ofStatus(getStatus(), getPins());
	}
	
	@Override
	protected Score scoreWith(Score beforeScore) {
		return getPins().scoreWith(beforeScore);
	}
}