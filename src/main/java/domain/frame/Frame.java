package domain.frame;

import domain.Pitch;
import domain.FrameStatus;

import java.util.*;


public abstract class Frame {
	public static final int DEFAULT_START_PIN_COUNT = 10;
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;
	
	private Pitch firstPitch;
	private Pitch secondPitch;
	private Frame nextFrame;
	private int frameNumber;
	

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

	public Frame bowl(int pinCount) {
		secondPitch = new Pitch(firstPitch.getRemainPinCount(), pinCount);
		return this;
	}

	protected Frame createNextFrame(int firstPitch) {
		if(frameNumber == MAX_FRAME_NUMBER) {
			throw new IllegalArgumentException("마지막 프레임 이후에는 프레임을 생성할 수 없습니다.");
		}
		
		if(frameNumber < MAX_FRAME_NUMBER - 1) {
			return nextFrame = new NormalFrame(frameNumber + 1, firstPitch);
		}
		return nextFrame = new FinalFrame(firstPitch);
	}
	
	public FrameStatus getStatus() {
		if(!isComplete()) {
			return FrameStatus.PLAYING;
		}
		
		if(!hasSecondPitch()) {
			return FrameStatus.STRIKE;
		}
		
		if(isPinRemained()) {
			return FrameStatus.MISS;
		}
		
		return FrameStatus.SPARE;
	}
	
	public abstract boolean isComplete();
}
