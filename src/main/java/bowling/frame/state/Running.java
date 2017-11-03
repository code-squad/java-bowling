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

	@Override
	public int[] getScore() {
		throw new NullPointerException("Finish 상태가 아닌 프레임은 점수를 반환 할 수 없습니다.");
	}
}