package bowling.model;

public class Ready implements State {
	
	@Override
	public State bowl(int knockedPins) {
		if(knockedPins == 10) {
			return new Strike();
		}
		return new FirstBowl(knockedPins);
	}

	@Override
	public boolean isEnd() {
		return false;
	}

}
