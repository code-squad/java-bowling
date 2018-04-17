package state;

import bowling.FrameInfo;
import bowling.Pins;
import bowling.TotalScore;
import frame.Frame;
import frame.SpareLastFrame;

public class Spare implements State {

	Pins firstRoll;

	public Spare(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	@Override
	public State update(int pinsDown) {
		return this;
	}

	@Override
	public FrameInfo setPinsDown(FrameInfo frameInfo) {
		frameInfo.setFirstRoll(firstRoll);
		frameInfo.setSecondRoll(new Pins(10 - firstRoll.getPinsDown()));
		return frameInfo;
	}

	@Override
	public TotalScore getTotalScore() {
		return new TotalScore(Pins.MAX, 1);
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
		return Pins.MAX - getFirstRoll();
	}

	@Override
	public Frame generateLastFrame() {
		return new SpareLastFrame();
	}

}
