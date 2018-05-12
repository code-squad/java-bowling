package domain.frame;

import domain.Score;

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
	public Score getScore() {
		Score score = Score.ofStatus(getStatus(), getPins());
		if(!score.getScoreFlag() && hasNextFrame()) {
			return getNextFrame().getScoreWith(score);
		}
		return score;
	}
	
	@Override
	protected Score getScoreWith(Score beforeScore) {
		Score score = getPins().scoreWith(beforeScore);
		if(hasNextFrame() && !score.getScoreFlag()) {
			return getNextFrame().getScoreWith(score);
		}
		
		return score;
	}
}
