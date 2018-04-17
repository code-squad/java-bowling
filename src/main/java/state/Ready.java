package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;
import frame.Frame;

public class Ready implements State {

	@Override
	public State update(int pinsDown) {
		if (pinsDown == Pins.MAX) {
			return new Strike();
		}
		return new FirstRoll(pinsDown);
	}
	
	@Override
	public TotalScore getTotalScore() {
		return null;
	}
	
	@Override
	public TotalScore addNextFrameScore(TotalScore totalScore) {
		return null;
	}
	
	@Override
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
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

}
