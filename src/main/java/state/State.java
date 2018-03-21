package state;

import bowling.Pins;

// Finish의 하위 클래스들은 필요 없는 정보도 있다. 고민
public abstract class State {
	protected Pins firstRoll;
	protected Pins secondRoll;

//	public abstract boolean isFinish();
	
	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}
}
