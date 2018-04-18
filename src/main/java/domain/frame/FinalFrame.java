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
	public boolean isComplete() {
		if(hasThirdPitch()) {
			return true;
		}
		
		if(hasSecondPitch()) {
			PlayStatus secondPitchStatus = getSecondPitch().getStatus();
			return secondPitchStatus == PlayStatus.OPEN
					 || secondPitchStatus == PlayStatus.STRIKE;
		}

		return false;
	}

	@Override
	public Frame bowl(int pinCount) {
		if(isComplete()) {
			return this;
		}
		
		if(!hasSecondPitch()) {
			return getLastPitch().isClear() ? super.resetAndBowl(pinCount) : super.bowl(pinCount);
		}

		if(!hasThirdPitch()) {
			thirdPitch = new Pitch(getLastPitch().isClear() ? DEFAULT_START_PIN_COUNT : getLastPitch().getRemainPinCount(), pinCount);
		}

		return this;
	}
}