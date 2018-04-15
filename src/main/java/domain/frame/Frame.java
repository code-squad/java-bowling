package domain.frame;

public abstract class Frame {
	protected int frameNumber;
	protected int firstPitch;
	protected int secondPitch;
	protected boolean completeFlag;
	
	public Frame(int frameNumber, int firstPitch) {
		this.frameNumber = frameNumber;
		this.firstPitch = firstPitch;
		completeFlag = false;
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}
	
	public boolean isComplete() {
		return completeFlag;
	}
	
	public abstract Frame bowl(int pinCount);
	
	
}
