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

	// 인풋값을 받아 인스턴스 변수 세팅
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

	private boolean isFrameEnd() {
		if (isPinsAllDown()) {
			return true;
		}
		return firstRoll != null && secondRoll != null;
	}

	private boolean isPinsAllDown() {
		return getFrameScore() == 10;
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

	// 호출 당시의 Frame의 토탈값을 제공해준다.
	public int getFrameTotal() {
		if (isSpareFrame()) {
			return getFrameScore() + nextFrame.getFirstRoll();
		}

		if (isStrikeFrame()) {
			return 10 + nextFrame.getRollStrikeFrameNeed();
		}

		return getFrameScore();
	}

	private boolean isSpareFrame() {
		if (isStrikeFrame()) {
			return false;
		}
		return getFrameScore() == 10;
	}

	private boolean isStrikeFrame() {
		return getFirstRoll() == 10;
	}

	private int getRollStrikeFrameNeed() {
		if (isStrikeFrame() && nextFrame != null) {
			return 10 + nextFrame.getFirstRoll();
		}
		return getFrameScore();
	}

	// 호출 당시의 Frame이 토탈값을 계산 할 수 있는 상태인지를 알려준다.
	public boolean readyToCalculateTotal() {
		if (isPinsAllDown() && nextFrame == null) {
			return false;
		}

		if (isSpareFrame() && !nextFrame.isFirstRollNull()) {
			return true;
		}

		if (isStrikeFrame() && nextFrame.isCalculatePreStrikeFrame(nextFrame)) {
			return true;
		}
		return isFrameEnd();
	}

	boolean isCalculatePreStrikeFrame(Frame prmNextFrame) {
		if (prmNextFrame.isStrikeFrame() && prmNextFrame.getNextFrame() == null) {
			return false;
		}
		
		if (prmNextFrame.isStrikeFrame() && prmNextFrame.getNextFrame() != null && !prmNextFrame.isFirstRollNull()) {
			return true;
		}

		if (prmNextFrame.isStrikeFrame() && prmNextFrame.getNextFrame() == null) {
			return false;
		}
		return prmNextFrame.isFrameEnd();
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

	public boolean isGameEnd() {
		return frameNo == 10 && isFrameEnd();
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

	public Frame getNextFrame() {
		return nextFrame;
	}

	public int getFrameNo() {
		return frameNo;
	}
}
