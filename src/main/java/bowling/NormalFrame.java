package bowling;

public class NormalFrame extends Frame {
	private Frame nextFrame;

	public NormalFrame(int frameNo) {
		super(new FrameNo(frameNo));

		if (frameNo == FrameNo.NOMAL_FRAME) {
			nextFrame = new LastFrame(FrameNo.MAX);
			return;
		}
		nextFrame = new NormalFrame(frameNo + FrameNo.MIN);
	}
	
	@Override
	public Frame getCurrentFrame() {
		if (isEndFrame()) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}

	@Override
	public int getCurrentFrameNo() {
		return getCurrentFrame().getFrameNo();
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
