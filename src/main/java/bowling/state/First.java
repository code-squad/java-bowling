package bowling.state;

public class First extends Running {

	public First(int firstBowlScore) {
		this.firstBowlScore = firstBowlScore;
	}

	@Override
	public State bowl(int secondBowlScore) {
		if (this.firstBowlScore + secondBowlScore == 10) {
			return new Spare(this.firstBowlScore, secondBowlScore);
		}
		return new Second(this.firstBowlScore, secondBowlScore);
	}
	
	

}
