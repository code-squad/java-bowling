package bowling;

public class Score {
	private TotalScore totalScore;
	private Pins firstRoll;
	private Pins secondRoll;

	public Score() {
		this.totalScore = new TotalScore();
	}
	
	public void setPinsDown(int pinsDown) {
		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		setSecondPinsDown(pinsDown);
	}

	public void setSecondPinsDown(int pinsDown) {
		secondRoll = new Pins(pinsDown);
		secondRoll.checkPinsValid(firstRoll);
	}
	
	public int getTotalScore() {
		return totalScore.getTotal();
	}
	
	public void setTotalScore(int total) {
		totalScore.setTotal(total);
	}

	public Pins getFirstRoll() {
		return firstRoll;
	}

	public void setFirstRoll(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	public Pins getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(Pins secondRoll) {
		this.secondRoll = secondRoll;
	}
}
