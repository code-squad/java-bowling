package bowling.state;

public abstract class Running extends NomalUtil implements State {
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
