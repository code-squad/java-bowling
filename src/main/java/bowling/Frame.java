package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import state.Ready;
import state.State;

public class Frame {

	private static final Logger log = LoggerFactory.getLogger(Frame.class);

	private int frameNo;
	private Frame nextFrame;
	private State state;

	public Frame() {
		this(1);
	}

	public Frame(int frameNo) {
		this.frameNo = frameNo;
		state = new Ready();
	}

	// 인풋값을 받아 인스턴스 변수 세팅
	public Frame roll(int pinsDown) {
		if (state.isFrameEnd()) {
			nextFrame = setNextFrame();
			return nextFrame.roll(pinsDown);
		}
		state = state.update(pinsDown);
		return this;
	}

	private Frame setNextFrame() {
		if (frameNo == Pins.MAX) {
			// 상수 교체
			return null;
		}

		if (nextFrame == null) {
			return new Frame(frameNo + 1);
		}
		return nextFrame;
	}

	public FrameScore getFrameScore() {
		return state.getFrameScore();
	}

	public boolean isGameEnd() {
		return frameNo == Pins.MAX && state.isFrameEnd();
		// 상수 교체
	}

	public int getFrameNo() {
		return frameNo;
	}

	public int getFrameNoForConsole() {
		if (state.isFrameEnd()) {
			return frameNo + 1;
		}
		return frameNo;
	}

	public State getState() {
		return state;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

}
