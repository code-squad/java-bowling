package sangco.bowling.model;

import sangco.bowling.model.state.BowlingState;
import sangco.bowling.model.state.Spare;
import sangco.bowling.model.state.Strike;

public class LastFrame implements Frame {
	private Frame nextFrame;
	private boolean totalSetOrNot = false;
	private int gameTotalScore = 0;
	private int firstRoll = 0;
	private Integer secondRoll = null;
	private Integer thirdRoll = null;

	public LastFrame(int firstRoll) {
		this.firstRoll = firstRoll;
	}

	@Override
	public void setNextRoll(int nextRoll) {
		if (secondRoll == null) {
			secondRoll = nextRoll;
			return;
		}
			thirdRoll = nextRoll;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		/*
		 * if(state == null) { gameTotalScore = getFrameScore(); } //gameTotalScore =
		 * state. totalSetOrNot = true;
		 */
		return 0;
	}

	@Override
	public int getScoreFirstRoll() {
		return firstRoll;
	}

	@Override
	public int getFrameScore() {
		return firstRoll + secondRoll;
	}

	@Override
	public int getTotalScore() {
		return gameTotalScore;
	}

	private boolean isStrike(int firstRoll) {
		return firstRoll == 10;
	}
	
	int getHowManyTimes() {
		return (thirdRoll == null) ? 2 : 3;
	}

	@Override
	public boolean getTotalSetOrNot() {
		return totalSetOrNot;
	}
}
