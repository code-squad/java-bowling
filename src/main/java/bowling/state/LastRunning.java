package bowling.state;

public abstract class LastRunning extends LastUtil implements State {
	@Override
	public boolean isEnd() {
		return false;
	}

	abstract public State bowl(int firstBowl);

	@Override
	public int getScore() {
		return this.firstBowlScore;
	}

}
