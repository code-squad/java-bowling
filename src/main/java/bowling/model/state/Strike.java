package bowling.model.state;

public class Strike extends EndState {
	private int score;

	public Strike() {
		score = 10;
	}
	
	@Override
	public String getScore() {
		return "X";
	}
}
