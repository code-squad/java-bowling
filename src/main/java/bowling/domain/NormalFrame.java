package bowling.domain;

public class NormalFrame extends Frame {

	public NormalFrame(int frameNum, Score score) {
		super(frameNum, score.getScore(0), score.getScore(1));
	}

	public NormalFrame(int frameNum, int firstDownPin) {
		super(frameNum, firstDownPin);
	}

	public static NormalFrame of(int frameNum, Score score) {
		if (score.size() == 1) {
			return new NormalFrame(frameNum, score.getScore(0));
		}
		return new NormalFrame(frameNum, score);
	}

	public String getDownPin() {
		return checkFirstPin() + checkSecondPin();
	}

	public String checkSecondPin() {
		if (isStrike()) {
			return "  ";
		}
		if (isSpare()) {
			return "|/";
		}
		return "|" + getSecondDownPin();
	}

}
