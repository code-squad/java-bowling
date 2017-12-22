package sangco.bowling.model.frame;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class LastFrame implements Frame {
	private int frameNumber = 0;
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int scoreThirdRoll = 0;
	private int gameTotalScore = 0;

	public LastFrame(int frameNumber, int scoreFirstRoll) {
		this.frameNumber = frameNumber;
		this.scoreFirstRoll = scoreFirstRoll;
		if (scoreFirstRoll == 10) {
			this.scoreSecondRoll = InputView.getScore(0);
		}
		if (scoreFirstRoll != 10) {
			this.scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		}
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(HashMap<Integer, Frame> scoreBoard, int totalScore) {
		scoreThirdRoll = setScoreThirdRoll();
		gameTotalScore = totalScore + getScoreFrame() + scoreThirdRoll;
		return gameTotalScore;
	}

	private int setScoreThirdRoll() {
		if (scoreFirstRoll == 10 && scoreSecondRoll == 10) {
			return InputView.getScore(0);
		}
		if (scoreFirstRoll == 10 && scoreSecondRoll != 10) {
			return InputView.getScore(scoreSecondRoll);
		}
		if (getScoreFrame() == 10) {
			return InputView.getScore(0);
		}
		return 0;
	}

	@Override
	public int getScoreFirstRoll() {
		return scoreFirstRoll;
	}

	@Override
	public int getScoreSecondRoll() {
		return scoreSecondRoll;
	}

	@Override
	public int getScoreFrame() {
		return scoreFirstRoll + scoreSecondRoll;
	}

	@Override
	public boolean getTotalSetOrNot() {
		return false;
	}
}