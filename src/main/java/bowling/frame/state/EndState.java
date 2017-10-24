package bowling.frame.state;

import bowling.exception.BowlingException;

public abstract class EndState implements State {
	int firstScore;
	int secondScore;

	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public State bowl(int score) {
		throw new BowlingException("endState 상태일때는 입력할 수 없습니다.");
	}

	abstract public String getChar();

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

}
