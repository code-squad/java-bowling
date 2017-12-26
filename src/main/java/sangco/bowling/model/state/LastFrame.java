package sangco.bowling.model.state;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class LastFrame extends Frame {
	private int scoreThirdRoll = 0;

	public LastFrame(int frameIndex, int scoreFirstRoll, int scoreSecondRoll) {
		super.frameNumber = frameIndex;
		super.scoreFirstRoll = scoreFirstRoll;
		super.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		scoreThirdRoll = setScoreThirdRoll();
		gameTotalScore = totalScore + getFrameScore() + scoreThirdRoll;
		return gameTotalScore;
	}

	private int setScoreThirdRoll() {
		if (scoreFirstRoll == 10 && scoreSecondRoll == 10) {
			return InputView.getScore(0);
		}
		if (scoreFirstRoll == 10 && scoreSecondRoll != 10) {
			return InputView.getScore(scoreSecondRoll);
		}
		if (getFrameScore() == 10) {
			return InputView.getScore(0);
		}
		return 0;
	}
}