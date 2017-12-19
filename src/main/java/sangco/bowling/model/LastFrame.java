package sangco.bowling.model;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setGameTotalScore(int totalScore) {
		// TODO Auto-generated method stub
		// 다른프레임과 똑같이 가고 여기서 다른 프레임과 다른 부분을 계산해 주자
		
	}
}
