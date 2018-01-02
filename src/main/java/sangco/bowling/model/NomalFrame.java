package sangco.bowling.model;

import sangco.bowling.model.state.BowlingState;
import sangco.bowling.model.state.Spare;
import sangco.bowling.model.state.Strike;

public class NomalFrame implements Frame {
	private Frame nextFrame;
	private BowlingState state;
	private boolean totalSetOrNot = false;
	private int gameTotalScore = 0;
	private int firstRoll = 0;
	private Integer secondRoll = null;

	public NomalFrame(int firstRoll) {
		this.firstRoll = firstRoll;
		if (isStrike(firstRoll)) {
			state = new Strike();
		}
	}

	@Override
	public void setNextRoll(int secondRoll) {
		this.secondRoll = secondRoll;
		if (isSpare()) {
			state = new Spare();
		}
	}


	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		if (secondRoll != null) {
			gameTotalScore = totalScore + getFrameScore();
			totalSetOrNot = true;
			return gameTotalScore;
		}
		return gameTotalScore;
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

	public int getTwoFrameNextFirstScore() {
		return ((NomalFrame) nextFrame).getNextFrame().getScoreFirstRoll();
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

	public BowlingState getState() {
		return state;
	}

	private boolean isStrike(int firstRoll) {
		return firstRoll == 10;
	}

	@Override
	public boolean getTotalSetOrNot() {
		return totalSetOrNot;
	}
	
	private boolean isSpare() {
		return getFrameScore() == 10 && isStrike(firstRoll) == false;
	}
}
