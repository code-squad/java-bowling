package bowling.domain;

abstract public class Frame {

	private int firstDownPin;
	private int secondDownPin;
	private Score score;

	public Frame(int firstDownPin, int secondDownPin, Score score) {
		this.firstDownPin = firstDownPin;
		this.secondDownPin = secondDownPin;
		this.score = score;
	}

	public Frame(int firstDownPin, Score score) {
		this.firstDownPin = firstDownPin;
		this.score = score;
	}

	abstract String getDownPin();

	abstract String checkSecondPin();

	public Score getScore() {
		return score;
	}

	public String checkFirstPin() {
		if (isStrike()) {
			return "X";
		}
		return String.valueOf(firstDownPin);
	}

	public Boolean isStrike() {
		return Pin.isStrike(firstDownPin);
	}

	public Boolean isSpare() {
		return Pin.isSpare(firstDownPin, secondDownPin);
	}

	public Boolean isSpare(int thirdDownPin) {
		return Pin.isSpare(secondDownPin, thirdDownPin);
	}

	public int getSecondDownPin() {
		return secondDownPin;
	}

	public void updateScore(int inputScore) {
		this.score = score.bowl(inputScore);
	}

	public Boolean canCalucateScore() {
		return score.canCalculateScore();
	}

	public Boolean canOnlyOneMoreCalculate() {
		return score.canOneMoreCalculate();
	}

}
