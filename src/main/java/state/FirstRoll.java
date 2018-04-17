package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;
import frame.Frame;

public class FirstRoll implements State {

	Pins firstRoll;

	public FirstRoll(int pinsDown) {
		this.firstRoll = new Pins(pinsDown);
	}

	@Override
	public State update(int pinsDown) {
		if (getPinsDown() + pinsDown == Pins.MAX) {
			return new Spare(firstRoll);
		}
		return new Miss(firstRoll, pinsDown);
	}

	@Override
	public TotalScore getTotalScore() {
		return null;
	}

	@Override
	public TotalScore addNextFrameScore(TotalScore totalScore) {
		totalScore = totalScore.addRoll(getPinsDown());
		
		if (totalScore.canCalculateScore()) {
			return totalScore;
		}
		return null;
	}
	
	@Override
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
		frameInfo.setFirstRoll(firstRoll);
		return frameInfo;
	}
	
	@Override
	public boolean isFrameEnd() {
		return false;
	}
	
	@Override
	public Frame generateLastFrame() {
		return null;
	}

	public int getPinsDown() {
		return firstRoll.getPinsDown();
	}

}
