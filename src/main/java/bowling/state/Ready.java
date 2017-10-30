package bowling.state;

public class Ready extends Running {

	public State bowl(int firstBowlScore) {
		if (firstBowlScore == 10) {
			return new Strike();
		}
		return new First(firstBowlScore);
	}

}
