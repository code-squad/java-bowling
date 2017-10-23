package bowling.frame.state;

public class TenFirst extends Running {
	private int first;

	public TenFirst(int countOfPin) {
		this.first = countOfPin;
	}

	@Override
	public State bowl(int countOfPin) {
		return new TenSecond(this.first, countOfPin);
	}
}
