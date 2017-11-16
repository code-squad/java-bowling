package bowling.frame.state;

public abstract class End implements State {

	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException("");
	}
	
	

}
