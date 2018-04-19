package domain.frame;

import domain.PlayStatus;
import domain.pitch.Pitches;

public abstract class Frame {
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;

	private Pitches pitches;
	private Frame nextFrame;
	private int frameNumber;
	
	public Frame(int frameNumber, int firstPitch) {
		this.frameNumber = frameNumber;
		this.pitches = new Pitches(firstPitch);
	}
	
	public Frame getNextFrame() {
		return nextFrame;
	}
	
	public boolean hasNextFrame() {
		return nextFrame != null;
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}
	
	public Pitches getPitches() {
		return pitches;
	}
	
	public abstract boolean isComplete();
	
	public boolean isFinalFrame() {
		return frameNumber == MAX_FRAME_NUMBER;
	}
	
	public Frame bowl(int pinCount) {
		if (isComplete()) {
			return createNextFrame(pinCount);
		}
		
		pitches.add(pinCount);
		return this;
	}
	
	protected Frame createNextFrame(int firstPitch) {
		if (frameNumber == MAX_FRAME_NUMBER) {
			throw new IllegalArgumentException("마지막 프레임 이후에는 프레임을 생성할 수 없습니다.");
		}
		
		if (frameNumber < MAX_FRAME_NUMBER - 1) {
			return nextFrame = new NormalFrame(frameNumber + 1, firstPitch);
		}
		return nextFrame = new FinalFrame(firstPitch);
	}
	
	public PlayStatus getStatus() {
		return pitches.getLast().getStatus();
	}
	
	public abstract boolean canScore();

	public abstract int score();
}
