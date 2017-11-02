package bowling.frame.state;

public abstract class Running implements State {
	protected int firstScore;

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public int getEachFinalFrameScore() {
		throw new IllegalArgumentException("Finish 상태가 아닌 프레임은 점수를 합산 할 수 없습니다.");
	}
}
