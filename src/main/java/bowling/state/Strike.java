package bowling.state;

import bowling.frame.Frame;

public class Strike extends End {

	@Override
	public String toString() {
		return "strike";
	}

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public String getChar() {
		return "  X   |";
	}
}
