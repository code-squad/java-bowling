package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;

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
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
		frameInfo.setFirstRoll(firstRoll);
		return frameInfo;
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
	public boolean isFrameEnd() {
		return false;
	}

	public int getPinsDown() {
		return firstRoll.getPinsDown();
	}

}
