package bowling.frame.state;

import bowling.frame.CannotCalculateException;

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
	int countOfFramePins() {
		return this.first + this.second + this.third;
	}

	@Override
	int noOfNextSum() {
		return 0;
	}

	public Score cacluateAdditionalScore(Score score) {
		throw new CannotCalculateException();
	}
}
