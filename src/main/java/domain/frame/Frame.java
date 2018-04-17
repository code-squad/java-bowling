package domain.frame;

import domain.Pitch;

import java.util.*;


public abstract class Frame {
	int frameNumber;
	Pitch firstPitch;
	Pitch secondPitch;
	public static final int DEFAULT_START_PIN_COUNT = 10;
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;

	public Frame(int frameNumber, int firstPitch) {
		this.frameNumber = frameNumber;
		if(firstPitch > DEFAULT_START_PIN_COUNT) {
			throw new IllegalArgumentException("10개 이상의 pinCount는 집계할 수 없습니다.");
		}
		this.firstPitch = new Pitch(DEFAULT_START_PIN_COUNT, firstPitch);
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}

	public abstract boolean isComplete();

	public abstract Frame bowl(int pinCount);
	
	public boolean hasSecondPitch() {
		return secondPitch != null;
	}

	public boolean isPinRemained() {
		if(hasSecondPitch()) {
			return !secondPitch.isClear();
		}
		return false;

	}

	public List<Pitch> getPitches() {
		List<Pitch> pitches = new ArrayList<>();
		pitches.add(firstPitch);
		pitches.add(secondPitch);
		return pitches;
	}
}
