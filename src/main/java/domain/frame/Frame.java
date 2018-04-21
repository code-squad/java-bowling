package domain.frame;

import domain.PlayStatus;
import domain.pitch.Pitches;

public abstract class Frame {
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;

	private Pitches pitches;
	private Frame nextFrame;
	private int frameNumber;
	
	public Frame(int frameNumber, int firstPin) {
		this.frameNumber = frameNumber;
		this.pitches = new Pitches(firstPin);
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
	
	public Frame bowl(int pin) {
		if (isComplete()) {
			return createNextFrame(pin);
		}
		
		pitches.add(pin);
		return this;
	}
	
	protected Frame createNextFrame(int firstPin) {
		if (frameNumber == MAX_FRAME_NUMBER) {
			throw new IllegalArgumentException("마지막 프레임 이후에는 프레임을 생성할 수 없습니다.");
		}
		
		if (frameNumber < MAX_FRAME_NUMBER - 1) {
			return nextFrame = new NormalFrame(frameNumber + 1, firstPin);
		}
		return nextFrame = new FinalFrame(firstPin);
	}
	
	public PlayStatus getStatus() {
		return pitches.getLast().getStatus();
	}
	
	public abstract boolean getScoreFlag();

	public abstract int getScore();
}
