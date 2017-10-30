package bowling.state;

public class Second extends End {

	public Second(int firstBowlScore, int secondBowlScore) {
		this.firstBowlScore = firstBowlScore;
		this.secondBowlScore = secondBowlScore;
	}

	@Override
	public int getScore() {
		return firstBowlScore + secondBowlScore;
	}
}
