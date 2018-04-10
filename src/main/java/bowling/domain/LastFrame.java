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

}
