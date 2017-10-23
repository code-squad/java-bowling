package bowling.frame.state;

public class TenThird extends Finished {
	private int first;
	private int second;
	private int third;

	public TenThird(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	@Override
	Score getScore() {
		return new Score(this.first + this.second + this.third, 0);
	}
}
