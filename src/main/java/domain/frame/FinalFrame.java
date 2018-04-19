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
					|| PlayStatus.MISS.equals(secondPitchStatus);
		}

		return false;
	}
	
	@Override
	public boolean canScore() {
		return isComplete();
	}

	@Override
	public int score() {
		if (!canScore()) {
			throw new IllegalStateException(getFrameNumber() + "프레임은 점수를 구할 수 없는 상태입니다.");
		}
		return getPitches().sum();
	}
}