package domain.frame;

import domain.Pitch;

import java.util.List;

public class FinalFrame extends Frame {
	private Pitch thirdPitch;
	
	public FinalFrame(int firstPitch) {
		super(Frame.MAX_FRAME_NUMBER, firstPitch);
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
			return !getSecondPitch().isClear();
		}

		return false;
	}

	@Override
	public Frame bowl(int pinCount) {
		if(!hasSecondPitch() && !getFirstPitch().isClear()) {
			super.bowl(pinCount);
		}else {
			thirdPitch = new Pitch(DEFAULT_START_PIN_COUNT , pinCount);
		}
		return this;
	}
}