package domain.frame;

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
	public boolean getScoreFlag() {
		Status nowStatus = getStatus();
		
		if (!isComplete()) {
			return false;
		}
		
		if (!nowStatus.ofInstance(Strike.class, Spare.class)) {
			return true;
		}
		
		if (nowStatus.ofInstance(Spare.class)) {
			return hasNextFrame();
		}
		
		if (!hasNextFrame()) {
			return false;
		}

		if (!getNextFrame().getStatus().ofInstance(Strike.class)) {
			return getNextFrame().isComplete();
		}

		return getNextFrame().hasNextFrame();
	}

	@Override
	public int getScore() {
		if (!getScoreFlag()) {
			throw new IllegalStateException(getFrameNumber() + "프레임은 점수를 구할 수 없는 상태입니다.");
		}

		int baseScore = getPins().sum();
		Status nowStatus = getStatus();

		if (!nowStatus.ofInstance(Strike.class)
				&& !nowStatus.ofInstance(Spare.class)) {
			return baseScore;
		}

		if (nowStatus.ofInstance(Spare.class)) {
			return baseScore
					+ getNextFrame().getPins().getFirst().getPin();
		}

		if (!getNextFrame().getStatus().ofInstance(Strike.class)) {
			return baseScore
					+ getNextFrame().getPins().sum();
		}

		return baseScore
				+ getNextFrame().getPins().sum()
				+ getNextFrame().getNextFrame().getPins().getFirst().getPin();
	}
}
