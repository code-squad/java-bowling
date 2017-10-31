package bowling.state;

public class LastFirst extends LastRunning {

	public LastFirst(int firstBowlScore) {
		this.firstBowlScore = firstBowlScore;
	}

	@Override
	public State bowl(int secondBowlScore) {
		if (this.firstBowlScore + secondBowlScore == 10) {
			return new Spare(this.firstBowlScore, secondBowlScore);
		}
		return new Second(this.firstBowlScore, secondBowlScore);
	}

	@Override
	public String getChar() {
		return "  " + firstBowlScore + "  |";
	}
}
