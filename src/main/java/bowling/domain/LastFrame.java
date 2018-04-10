package bowling.domain;

public class LastFrame extends Frame {

	private int thirdDownPin;

	public LastFrame(int frameNum, Score score) {
		super(frameNum, score.getScore(0), score.getScore(1));
	}

	public LastFrame(int frameNum, Score score, int thirdDownPin) {
		super(frameNum, score.getScore(0), score.getScore(1));
		this.thirdDownPin = thirdDownPin;
	}

	public static LastFrame of(int frameNum, Score score) {
		if (score.size() == 3) {
			return new LastFrame(frameNum, score, score.getScore(2));
		}
		return new LastFrame(frameNum, score);
	}

	public String getDownPin() {
		return checkFirstPin() + "|" + checkSecondPin() + "|" + checkThirdPin();
	}

	public String checkSecondPin() {
		if (isSpare()) {
			return "/";
		}
		if (isStrkeSecondPin()) {
			return "X";
		}
		return String.valueOf(getSecondDownPin());
	}

	public String checkThirdPin() {
		if (isSpare()) {
			return String.valueOf(thirdDownPin);
		}
		if (isSpare(thirdDownPin)) {
			return "/";
		}
		if (thirdDownPin == Score.STRIKE) {
			return "X";
		}
		return String.valueOf(thirdDownPin);
	}
}
