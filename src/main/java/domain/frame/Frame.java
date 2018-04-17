package domain.frame;

import domain.Pitch;

import java.util.*;


public abstract class Frame {
	public static final int DEFAULT_START_PIN_COUNT = 10;
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;

	private int frameNumber;
	private Pitch firstPitch;
	private Pitch secondPitch;

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

	protected Pitch getFirstPitch() {
		return firstPitch;
	}

	protected Pitch getSecondPitch() {
		return secondPitch;
	}

	protected void setSecondPitch(Pitch secondPitch) {
		this.secondPitch = secondPitch;
	}

	public List<Pitch> getPitches() {
		List<Pitch> pitches = new ArrayList<>();
		pitches.add(firstPitch);
		pitches.add(secondPitch);
		return pitches;
	}

	public boolean hasSecondPitch() {
		return secondPitch != null;
	}

	public boolean isPinRemained() {
		if(hasSecondPitch()) {
			return !secondPitch.isClear();
		}
		return !firstPitch.isClear();
	}

	public boolean isFinalFrame() {
		return frameNumber == MAX_FRAME_NUMBER;
	}

	public abstract Frame bowl(int pinCount);

	public abstract boolean isComplete();
}
