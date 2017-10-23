package bowling.frame.state;

public abstract class Finished implements State {
	@Override
	public State bowl(int countOfPin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isFinish() {
		return true;
	}
	
	@Override
	public Score getScore() {
		return new Score(countOfFramePins(), noOfNextSum());
	}
	
	abstract int countOfFramePins();
	
	abstract int noOfNextSum();
}
