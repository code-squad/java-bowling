package bowling.model.state;

public class FirstBowl implements State{
	private int knockedPins;
	
	public FirstBowl(int knockedPins) {
		this.knockedPins = knockedPins;
	}
	
	@Override
	public State bowl(int knockedPins) {
		if(this.knockedPins + knockedPins == 10) {
			return new Spare(this.knockedPins, knockedPins);
		}
		return new Normal(this.knockedPins, knockedPins);
	}

	@Override
	public boolean isEnd() {
		return false;
	}
	
}
