package bowling.model.state;

public class Strike extends EndState {

	public Strike() {
	}

	@Override
	public String getKnockedPins() {
		return "X";
	}

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public int getFirstScore() {
		return 10;
	}
}
