package domain.frame;

import domain.pin.Pins;
import domain.status.Ready;
import domain.status.Status;

import java.util.Arrays;
import java.util.List;

public abstract class Frame {
	public static final int MIN_FRAME_NUMBER = 1;
	public static final int MAX_FRAME_NUMBER = 10;
	
	private Pins pins;
	private Frame nextFrame;
	private int frameNumber;
	private List<Status> statusHistory;
	
	public Frame(int frameNumber, int firstPin) {
		this.frameNumber = frameNumber;
		this.pins = new Pins(firstPin);
		statusHistory = Arrays.asList(new Ready().next(firstPin));
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
		return statusHistory.get(statusHistory.size() - 1);
	}
	
	public List<Status> getStatusHistory() {
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
		
		pins.add(pin);
		statusHistory.add(getStatus().next(pin));
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
	
	public abstract boolean getScoreFlag();

	public abstract int getScore();
}
