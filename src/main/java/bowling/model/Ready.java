package bowling.model;

public class Ready extends Pins {

	public Score getScore() {
		return new Score(-1, -1);
	}
	
	protected String makeFirstPinStatus() {
		return "";
	}
	
	public Score calculate(Score score) {
		return score;
	}
}
