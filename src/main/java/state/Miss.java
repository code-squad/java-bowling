package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;

public class Miss implements State {
	
	Pins firstRoll;
	Pins secondRoll;

	public Miss(Pins firstRoll, int pinsDown) {
		this.firstRoll = firstRoll;
		this.secondRoll = new Pins(pinsDown);
	}

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
		frameInfo.setFirstRoll(firstRoll);
		frameInfo.setSecondRoll(secondRoll);
		return frameInfo;
	}

	@Override
	public TotalScore getTotalScore() {
		return new TotalScore(getFrameScoreInt(), 0);
	}
	
	private int getFrameScoreInt() {
		return firstRoll.getPinsDown() + secondRoll.getPinsDown();
	}
	
	@Override
	public TotalScore addNextFrameScore(TotalScore totalScore) {
		totalScore = totalScore.addRoll(getFirstRoll());
		
		if (totalScore.canCalculateScore()) {
			return totalScore;
		}
		totalScore = totalScore.addRoll(getSecondRoll());
		return totalScore;
	}
	
	@Override
	public boolean isFrameEnd() {
		return true;
	}

	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}
	
}
