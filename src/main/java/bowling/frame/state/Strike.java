package bowling.frame.state;

public class Strike extends EndState {
	final private int strikeScore = 10;

	@Override
	public String getChar() {
		return "  X   |";
	}

	@Override
	public int getFristScore() {
		return strikeScore;
	}

}
