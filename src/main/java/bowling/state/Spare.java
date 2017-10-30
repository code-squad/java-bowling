package bowling.state;

public class Spare extends End {

	public Spare(int firstBowlScore, int secondBowlScore) {
		this.firstBowlScore = firstBowlScore;
		this.secondBowlScore = secondBowlScore;
	}

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public String getChar() {
		return "  " + firstBowlScore + "/  |";
	}

}
