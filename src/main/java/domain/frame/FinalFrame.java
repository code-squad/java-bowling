package domain.frame;

public class FinalFrame extends Frame {
	private int thirdPitch;
	
	public FinalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
	}
	
	@Override
	public Frame bowl(int pinCount) {
		if(!completeFlag && firstPitch + secondPitch == 10) {
			thirdPitch = pinCount;
			completeFlag = true;
		}
		
		return this;
	}
}