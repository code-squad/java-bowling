package bowling.frame.ten;

import bowling.frame.state.EndState;

public class TenThird extends EndState {
	private int first;
	private int second;
	private int third;

	public TenThird(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
}
