package bowling.frame.state;

public abstract class Finish implements State {
	protected int firstScore;
	protected int secondScore;

	@Override
	public State bowl(int bowls) {
		throw new IllegalArgumentException("Finish 상태일때는 점수를 입력할 수 없습니다.");
	}

	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public int getEachFinalFrameScore() {
		return firstScore + secondScore;
	}

	@Override
	abstract public int[] getScore();
}