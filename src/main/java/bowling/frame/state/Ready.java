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
	public boolean isEnd() {
		return false;
	}

	@Override
	public String getChar() {
		return "      |";
	}

	@Override
	public int getEachFinalFrameScore() {
		throw new RuntimeException("Finish 상태가 아닌 프레임은 점수를 합산 할 수 없습니다.");
	}

	@Override
	public int getFirstScore() {
		return 0;
	}

}
