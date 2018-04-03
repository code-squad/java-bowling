package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);
	private int frameNo;
	private Frame nextFrame;
	private Pins firstRoll;
	private Pins secondRoll;

	public Frame(int frameNo) {
		this.frameNo = frameNo;

		if (frameNo == 10) {
			nextFrame = null;
			return;
		}
		nextFrame = new Frame(frameNo + 1);
	}

	public void roll(int pinsDown) {
		if (isFrameEnd()) {
			nextFrame.roll(pinsDown);
		}

		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		secondRoll = new Pins(pinsDown);
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

	public int getTotalScore() {
		return getTotalScore(0);
	}
	
	public int getTotalScore(int totalScore) {
		if (isFrameEnd()) {
			return nextFrame.getTotalScore(totalScore + getFrameScore());
		}
		return totalScore + getFrameScore();
	}
	
	public int getFrameScore() {
		return getFirstRoll() + getSecondRoll();
	}

	public Frame getCurrentFrame() {
		if (isFrameEnd()) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}

	private boolean isFrameEnd() {
		return firstRoll != null && secondRoll != null;
	}

	public Frame getNextFrame() {
		if (nextFrame == null) {
			throw new EndGameException();
		}
		return nextFrame;
	}

	public int getFrameNo() {
		return frameNo;
	}
}
