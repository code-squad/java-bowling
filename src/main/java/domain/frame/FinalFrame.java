package domain.frame;

import domain.Pitch;

import java.util.List;

public class FinalFrame extends Frame {
	private Pitch thirdPitch;
	
	public FinalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
	}
	
	@Override
	public List<Pitch> getPitches() {
		List<Pitch> pitches = super.getPitches();
		pitches.add(thirdPitch);
		return pitches;
	}

	public boolean hasThirdPitch() {
		return thirdPitch != null;
	}

	@Override
	public boolean isPinRemained() {
		if(hasThirdPitch()) {
			return !thirdPitch.isClear();
		}

		return super.isPinRemained();
	}

	@Override
	public boolean isComplete() {
		if(hasThirdPitch()) {
			return true;
		}

		if(hasSecondPitch()) {
			return !secondPitch.isClear();
		}

		return false;
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return this;
		}

		if(!firstPitch.isClear() && !hasSecondPitch()) {
			secondPitch = new Pitch(firstPitch.getRemainPinCount(), pinCount);
		}else {
			thirdPitch = new Pitch(DEFAULT_START_PIN_COUNT , pinCount);
		}
		return this;
	}
}