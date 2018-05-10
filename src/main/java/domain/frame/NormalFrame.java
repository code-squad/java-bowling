package domain.frame;

import domain.PlayStatus;
import domain.status.Spare;
import domain.status.Status;
import domain.status.Strike;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPin) {
		super(frameNumber, firstPin);
	}
	
	public NormalFrame(int firstPin) {
		super(MIN_FRAME_NUMBER, firstPin);
	}
	
	@Override
	public boolean isComplete() {
		return getStatus().isClear();
	}
	
	@Override
	public boolean getScoreFlag() {
		Status nowStatus = getStatus();
		
		if (!isComplete()) {
			return false;
		}
		
		if (!(nowStatus instanceof Strike)
				&& !(nowStatus instanceof Spare)) {
			return true;
		}
		
		if (PlayStatus.SPARE.equals(nowStatus)) {
			return hasNextFrame();
		}
		
		if (!hasNextFrame()) {
			return false;
		}

		if (!PlayStatus.STRIKE.equals(getNextFrame().getStatus())) {
			return getNextFrame().isComplete();
		}

		return getNextFrame().hasNextFrame();
	}

	@Override
	public int getScore() {
		if (!getScoreFlag()) {
			throw new IllegalStateException(getFrameNumber() + "프레임은 점수를 구할 수 없는 상태입니다.");
		}

//		int baseScore = getPitches().sum();
//		PlayStatus nowStatus = getStatus();
//
//		if (!PlayStatus.STRIKE.equals(nowStatus)
//				&& !PlayStatus.SPARE.equals(nowStatus)) {
//			return baseScore;
//		}
//
//		if (PlayStatus.SPARE.equals(nowStatus)) {
//			return baseScore
//					+ getNextFrame().getPitches().get(1).getPin();
//		}
//
//		if (!PlayStatus.STRIKE.equals(getNextFrame().getStatus())) {
//			return baseScore
//					+ getNextFrame().getPitches().sum();
//		}
//
//		return baseScore
//				+ getNextFrame().getPitches().sum()
//				+ getNextFrame().getNextFrame().getPitches().get(1).getPin();
		return 0;
	}
}
