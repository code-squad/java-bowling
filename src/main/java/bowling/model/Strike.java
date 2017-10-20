package bowling.model;

public class Strike implements State {
	private int knockedPins;
	
	public Strike() {
		knockedPins = 10;
	}
	
	@Override
	public State bowl(int knockedPins) {
		return null;
	}

	@Override
	public boolean isEnd() {
		return true;
	}

}
