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
		PlayStatus currentStatus = getStatus();
		
		if (!isComplete()) {
			return false;
		}
		
		if (!PlayStatus.STRIKE.equals(currentStatus)
				&& !PlayStatus.SPARE.equals(currentStatus)) {
			return true;
		}
		
		if (PlayStatus.SPARE.equals(currentStatus)) {
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
	public int score() {
		if (!canScore()) {
			throw new IllegalStateException(getFrameNumber() + "프레임은 점수를 구할 수 없는 상태입니다.");
		}

		int baseScore = getPitches().sum();
		PlayStatus currentStatus = getStatus();

		if (!PlayStatus.STRIKE.equals(currentStatus)
				&& !PlayStatus.SPARE.equals(currentStatus)) {
			return baseScore;
		}

		if (PlayStatus.SPARE.equals(currentStatus)) {
			return baseScore
					+ getNextFrame().getPitches().get(1).getPinCount();
		}

		if (!PlayStatus.STRIKE.equals(getNextFrame().getStatus())) {
			return baseScore
					+ getNextFrame().getPitches().sum();
		}

		return baseScore
				+ getNextFrame().getPitches().sum()
				+ getNextFrame().getNextFrame().getPitches().get(1).getPinCount();
	}
}
