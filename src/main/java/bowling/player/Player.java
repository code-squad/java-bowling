package bowling.player;

import bowling.frame.Frame;

public class Player {

	private int no;
	private Frame frame;

	public Player(int no) {
		this.no = no;
		this.frame = new Frame(1);
	}

	public int getNo() {
		return no;
	}

	public int bowl(int i) {
		return i;
	}
}
