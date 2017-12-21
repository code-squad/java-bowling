package sangco.bowling.model.frame;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class LastFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int scoreThirdRoll = 0;
	private int gameTotalScore = 0;
	private int frameTotalScore = 0;
	
	public LastFrame(int scoreFirstRoll) {
		this.scoreFirstRoll = scoreFirstRoll;

		if(this.scoreFirstRoll == 10) {
			this.scoreSecondRoll = InputView.getScore();
			this.scoreThirdRoll = InputView.getScore(scoreSecondRoll);
		}
		
		this.scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		
		if(this.scoreFirstRoll + this.scoreSecondRoll == 10) {
			this.scoreThirdRoll = InputView.getScore();
		}
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(int totalScore, int scoreFirstRoll) {
		gameTotalScore = totalScore + scoreFirstRoll + scoreSecondRoll + scoreThirdRoll;
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
