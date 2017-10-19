package bowling.frame;

class Miss extends EndState {
	private int first;
	private int second;

	Miss(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
