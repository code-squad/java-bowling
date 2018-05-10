package domain.frame;

public class FinalFrame extends Frame {
	public FinalFrame(int firstPin) {
		super(MAX_FRAME_NUMBER, firstPin);
	}
	
	@Override
	public boolean isComplete() {
		if (getPitches().has(3)) {
			return true;
		}
		
		if (getStatus().isClear()) {
			return true;
		}

		return false;
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
		return getPitches().sum();
	}
}