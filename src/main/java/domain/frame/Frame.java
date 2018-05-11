package domain.frame;

import domain.pin.Pins;
import domain.status.Status;
import domain.status.StatusHistory;

public abstract class Frame {
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;
	
	private Pins pins;
	private Frame nextFrame;
	private int frameNumber;
	private StatusHistory statusHistory;
	
	public Frame(int frameNumber, int firstPin) {
		this.frameNumber = frameNumber;
		this.pins = new Pins(firstPin);
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
	
	public Status getStatus() {
		return statusHistory.getLatest();
	}
	
	public StatusHistory getStatusHistory() {
		return statusHistory;
	}
	
	public abstract boolean isComplete();
	
	public boolean isFinalFrame() {
		return frameNumber == MAX_FRAME_NUMBER;
	}
	
	public Frame bowl(int pin) {
		if (isComplete()) {
			return createNextFrame(pin);
		}
		
		statusHistory.add(pin);
		pins.add(pin);
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

	public Pins getPins() {
	    return pins;
    }
	
	public abstract boolean getScoreFlag();

	public abstract int getScore();

}
