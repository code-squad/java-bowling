package bowling.state;

public class LastStrike extends LastRunning {

	public LastStrike(int firstBowlScore) {
		this.firstBowlScore = firstBowlScore;
	}

	@Override
	public String getChar() {
		return "x";
	}

	@Override
	public State bowl(int secondBowlScore) {
		return new LastBonuce(firstBowlScore, secondBowlScore);
	}

}
