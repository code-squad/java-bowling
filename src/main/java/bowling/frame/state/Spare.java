package bowling.frame.state;

class Spare extends EndState {
	private int first;
	private int second;

	Spare(int first, int second) {
		if (first + second != 10) {
			throw new IllegalArgumentException();
		}
		
		this.first = first;
		this.second = second;
	}
}
