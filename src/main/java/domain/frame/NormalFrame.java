package domain.frame;

import domain.Score;
import domain.status.*;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPin) {
		super(frameNumber, firstPin);
	}
	
	public NormalFrame(int firstPin) {
		super(MIN_FRAME_NUMBER, firstPin);
	}
	
	@Override
	public boolean isComplete() {
		return getStatus().isComplete();
	}
	
	@Override
	public Score score() {
		Score score = Score.ofStatus(getStatus(), getPins());
		if(!score.canScore() && hasNextFrame()) {
			return getNextFrame().scoreWith(score);
		}
		return score;
	}
	
	@Override
	protected Score scoreWith(Score beforeScore) {
		Score score = getPins().scoreWith(beforeScore);
		if(hasNextFrame() && !score.canScore()) {
			return getNextFrame().scoreWith(score);
		}
		
		return score;
	}
}
