package domain.frame;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNumber, int firstPitch) {
		super(frameNumber, firstPitch);
		if(firstPitch == 10) {
			completeFlag = true;
		}
	}
	
	@Override
	public Frame bowl(int pinCount) {
		if(completeFlag) {
			if(frameNumber < 9) {
				return new NormalFrame(++frameNumber, pinCount);
			}
			return new FinalFrame(++frameNumber, pinCount);
		}
		
		secondPitch = pinCount;
		completeFlag = true;
		return this;
	}
}
