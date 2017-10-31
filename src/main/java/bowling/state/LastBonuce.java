package bowling.state;

public class LastBonuce extends LastEnd {

	public LastBonuce(int firstBowlScore, int secondBowlScore) {
		this.firstBowlScore = firstBowlScore;
		this.secondBowlScore = secondBowlScore;
	}

	public void bowl(int score) {
		this.thirdBowlScore = score;
	}

}
