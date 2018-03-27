package bowling;

import com.sun.istack.internal.NotNull;

public class NomalFrame extends Frame {
	private Frame nextFrame;

	public NomalFrame(FrameNo frameNo) {
		super(frameNo);
		nextFrame = frameNo.createNextFrame(frameNo);
	}

	@Override
	public void roll(Pins pinsDown) {
		if (frameDone) {
			nextFrame.roll(pinsDown);
			return;
		}
		
		if (firstRoll == null) {
			firstRoll = pinsDown;
			frameDone = firstRoll.checkFrameDone();
			return;
		}
		
		secondRoll = pinsDown;
		frameDone = secondRoll.checkFrameDone(firstRoll);
	}

	@Override
	public Frame getCurrentFrame() {
		if (frameDone) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}
	
	@Override
	public Frame getNextFrame() {
		return nextFrame;
	}
	
	@Override
	public boolean isEndGame() {
		return false;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNo() + "]";
	}
}
