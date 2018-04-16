package domain.frame;

import domain.Pitch;


public abstract class Frame {
	int frameNumber;
	Pitch firstPitch;
	Pitch secondPitch;
	static final int DEFAULT_START_PIN_COUNT = 10;
	static final int MAX_FRAME_NUMBER = 10;

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
}
