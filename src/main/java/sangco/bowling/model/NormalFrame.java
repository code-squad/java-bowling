package sangco.bowling.model;

import sangco.bowling.view.InputView;

public class NormalFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int frameTotalScore = 0;
	private int gameTotalScore = 0;
	
	
	public NormalFrame(int scoreFirstRoll) {
		this.scoreFirstRoll = scoreFirstRoll;
		if(this.scoreFirstRoll != 10) {
			this.scoreSecondRoll = InputView.getScore();
		}
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}


	@Override
	public void setGameTotalScore(int totalScore) {
		gameTotalScore = Board.getTotalScoreList().get(0) + totalScore;
	}
}
