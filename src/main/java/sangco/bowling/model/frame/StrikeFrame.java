package sangco.bowling.model.frame;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class StrikeFrame implements Frame {
	private final int scoreFirstRoll = 10;
	private final int scoreSecondRoll = 0;
	private int frameTotalScore = 0;
	private int gameTotalScore = 0;

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(int totalScore, int scoreFirstRoll) {
		gameTotalScore = totalScore + 20 + scoreFirstRoll;
		return gameTotalScore;
	}

	public int setGameTotalScoreStrike(int totalScore, int scoreFirstRoll, int scoreSecondRoll) {
		if(scoreFirstRoll == 10) {
			return 0;
		}
		gameTotalScore = totalScore + 10 + scoreFirstRoll + scoreSecondRoll;
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
