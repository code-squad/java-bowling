package bowling;

public class NormalFrame extends Frame {
	private Frame nextFrame;

	public NormalFrame(int frameNo) {
		super(new FrameNo(frameNo));

		if (frameNo == FrameNo.MAX) {
			nextFrame = new LastFrame(FrameNo.MAX, getState());
			return;
		}
		nextFrame = new NormalFrame(frameNo + FrameNo.MIN);
	}

	@Override
	public Frame getCurrentFrame() {
		if (getState().isFinish()) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}

	@Override
	public int getCurrentFrameNo() {
		return getCurrentFrame().getIntFrameNo();
	}

	@Override
	public Frame getNextFrame() {
		return nextFrame;
	}

	@Override
	public boolean isEndGame() {
		// TODO Auto-generated method stub
		return false;
	}
}
