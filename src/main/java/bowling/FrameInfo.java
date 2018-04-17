package bowling;

import frame.Frame;
import state.State;

public class FrameInfo {

	private Pins firstRoll;
	private Pins secondRoll;
	private TotalScore totalScore;
	private int frameNo;
	
	public FrameInfo(int frameNo) {
		this.frameNo = frameNo;
	}
	
	public FrameInfo(int frameNo, TotalScore totalScore) {
		this(frameNo);
		this.totalScore = totalScore;
	}

	public int getFirstRoll() {
		return firstRoll.getPinsDown();
	}
	
	public void setFirstRoll(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	public boolean isFirstRollNull() {
		if (firstRoll == null) {
			return true;
		}
		return false;
	}

	public int getSecondRoll() {
		return secondRoll.getPinsDown();
	}
	
	public void setSecondRoll(Pins secondRoll) {
		this.secondRoll = secondRoll;
	}
	
	public boolean isSecondRollNull() {
		if (secondRoll == null) {
			return true;
		}
		return false;
	}

	public int getFrameScore() {
		return getFirstRoll() + getSecondRoll();
	}

	public int getInputFrameNo() {
		if (frameNo == 10) {
			return frameNo;
		}
		
		if (isFrameEnd()) {
			return frameNo + 1;
		}
		return frameNo;
	}
	
	private boolean isFrameEnd() {
		if (firstRoll.isStrike()) {
			return true;
		}
		
		if (isFirstRollNull() && isSecondRollNull()) {
			return true;
		}
		return false;
	}

	public int getFrameNo() {
		return frameNo;
	}

	public TotalScore getTotalScore() {
		return totalScore;
	}
	
	public boolean isTotalScoreNull() {
		if (totalScore == null) {
			return true;
		}
		return false;
	}
	
}
