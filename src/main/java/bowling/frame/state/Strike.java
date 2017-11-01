package bowling.frame.state;

public class Strike extends Finish {
	@Override
	public String getChar() {
		return "  X   |";
	}

	@Override
	public int getEachFinalFrameScore() {
		return 10;
	}

	@Override
	public int getFirstScore() {
		return 10;
	}
}
