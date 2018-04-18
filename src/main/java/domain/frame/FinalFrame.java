package domain.frame;

import domain.PlayStatus;
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
		if(hasThirdPitch()) {
			pitches.add(thirdPitch);
		}
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
		if(!isComplete() && !isPinRemained()) {
			resetPin();
		}
		
		if(!hasSecondPitch()) {
			return super.bowl(pinCount);
		}

		if(!hasThirdPitch()) {
			thirdPitch = new Pitch(getRemainedPinCount(), pinCount);
		}

		return this;
	}
}