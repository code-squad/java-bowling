package bowling.model.state;

public abstract class EndState implements State {

	@Override
	public State bowl(int knockedPins) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEnd() {
		return true;
	}
	
	abstract public int getScore();
	
	abstract public boolean calculateSumScore(int beforeSum);
	
	abstract public int getSumScore();
	
}
