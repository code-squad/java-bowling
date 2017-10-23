package bowling.frame.state;

public class TenReady extends Running {
	@Override
	public State bowl(int countOfPin) {
		return new TenFirst(countOfPin);
	}
}
