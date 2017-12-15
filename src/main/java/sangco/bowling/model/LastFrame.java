package sangco.bowling.model;

import sangco.bowling.view.InputView;

public class LastFrame implements Frame {
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int scoreThirdRoll = 0;
	
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
}
