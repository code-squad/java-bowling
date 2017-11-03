package bowling.frame.state;

public class Ready implements State {

	@Override
	public State bowl(int bowls) {
		if (bowls == 10) {
			return new Strike();
		}
		return new First(bowls);
	}

	@Override
	public String getChar() {
		return "      |";
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public int getEachFinalFrameScore() {
		throw new RuntimeException();
	}

	@Override
	public int getFirstScore() {
		return 0;
	}

	@Override
	public int[] getScore() {
		throw new NullPointerException("Finish 상태가 아닌 프레임은 점수를 반환 할 수 없습니다.");
	}
}