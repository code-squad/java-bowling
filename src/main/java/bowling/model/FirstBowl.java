package bowling.model;

public class FirstBowl implements State{
	private int knockedPins;
	
	public FirstBowl(int knockedPins) {
		this.knockedPins = knockedPins;
	}
	
	@Override
	public State bowl(int knockedPins) {
		if(knockedPins == 10) {
			return new Strike();
		}
		return null;
	}

	@Override
	public boolean isEnd() {
		return false;
	}
	
}
