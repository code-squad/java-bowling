package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);
	private int frameNo;
	private Frame nextFrame;
	private Pins firstRoll;
	private Pins secondRoll;

	public Frame() {
		this(1);
	}

	public Frame(int frameNo) {
		this.frameNo = frameNo;
	}

	public Frame roll(int pinsDown) {
		if (isFrameEnd()) {
			nextFrame = setNextFrame();
			return nextFrame.roll(pinsDown);
		}

		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return this;
		}
		secondRoll = new Pins(pinsDown);
		return this;
	}

	private Frame setNextFrame() {
		if (frameNo == 10) {
			return null;
		}

		if (nextFrame == null) {
			return new Frame(frameNo + 1);
		}
		return nextFrame;
	}

	public int getFirstRoll() {
		if (firstRoll == null) {
			return 0;
		}
		return firstRoll.getPinsDown();
	}

	public int getSecondRoll() {
		if (secondRoll == null) {
			return 0;
		}
		return secondRoll.getPinsDown();
	}

	public boolean isFirstRollNull() {
		return firstRoll == null;
	}

	public boolean isSecondRollNull() {
		return secondRoll == null;
	}

	public int getFrameScore() {
		return getFirstRoll() + getSecondRoll();
	}

	public int getFrameTotal() {
		if (isSpareFrame()) {
			return getFrameScore() + nextFrame.getFirstRoll();
		}
		return getFrameScore();
	}

	public boolean readyToCalculateTotal() {
		if (isSpareFrame() && nextFrame == null) {
			return false;
		}
		
		if (isSpareFrame() && !nextFrame.isFirstRollNull()) {
			return true;
		}

		return isFrameEnd();
	}

	private boolean isSpareFrame() {
		return getFrameScore() == 10;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

	public boolean isFrameEnd() {
		return firstRoll != null && secondRoll != null;
	}

	public boolean isGameEnd() {
		return frameNo == 10 && isFrameEnd();
	}

	public int getFrameNo() {
		return frameNo;
	}
}
