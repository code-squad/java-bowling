package bowling.state;

public class LastReady extends LastRunning {

	@Override
	public String getChar() {
		return "      |";
	}

	public State bowl(int firstBowlScore) {
		if (firstBowlScore == 10) {
			return new LastStrike(firstBowlScore);
		}
		return new LastFirst(firstBowlScore);
	}

}
