package sangco.bowling.model.frame;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class NormalFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int frameTotalScore = 0;
	private int gameTotalScore = 0;

	public NormalFrame(int scoreFirstRoll, int scoreSecondRoll) {
		this.scoreFirstRoll = scoreFirstRoll;
		this.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(int totalScore, int scoreFirstRoll) {
		gameTotalScore = totalScore + scoreFirstRoll + scoreSecondRoll;
		return gameTotalScore;
	}

	@Override
	public int getScoreFirstRoll() {
		return scoreFirstRoll;
	}

	@Override
	public int getScoreSecondRoll() {
		return scoreSecondRoll;
	}
}
