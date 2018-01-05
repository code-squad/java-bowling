package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

public abstract class Frame {
	private int frameNum;
	private ArrayList<Integer> frame = new ArrayList<>();
	private Frame nextFrame;

	public Frame(int frameNum) {
		this.frameNum = frameNum;
	}

	protected ArrayList<Integer> getFrame() {
		return frame;
	}

	protected boolean isFrameEmpty() {
		return frame.isEmpty();
	}
	
	public boolean isAddPossible(HashMap<Integer, Frame> frames) {
		if (frames.get(frameNum) != null)
			return frames.get(frameNum) == this;
		return true;
	}
	
	public void addFrames(HashMap<Integer, Frame> frames) {
		frames.put(frameNum, this);
	}

	protected int getFrameSize() {
		return frame.size();
	}

	protected Frame addScore(int score) {
		frame.add(score);

		if (isNotEnd()) 
			return this;
		if (frameNum < 8) {
			this.nextFrame = new NormalFrame(frameNum + 1);
			return nextFrame;
		}
		this.nextFrame = new FinalFrame(frameNum + 1);
		return nextFrame;
	}

	protected Integer getFirstPin() {
		if (frame.size() >= 1)
			return frame.get(0);
		return null;
	}

	protected Integer getSecondPin() {
		if (frame.size() >= 2)
			return frame.get(1);
		return null;
	}

	protected Integer getBonusPin() {
		if (frame.size() >= 3)
			return frame.get(2);
		return null;
	}

	protected Integer getNextFrameFirstPin() {
		if (nextFrame.getFirstPin() != null)
			return nextFrame.getFirstPin();
		return null;
	}

	protected boolean isFinalSpareStrike() {
		return frame.size() == 3;
	}
	
	public Integer getScore() {
		if (getStatus() == Status.MISSORNORMAL)
			return frame.get(0) + frame.get(1);
		if (isSpare() && calcSparePin(frameNum) != null)
			return 10 + calcSparePin(frameNum);
		if (isStrike() && calcStrikePin(frameNum) != null){
			return 10 + calcStrikePin(frameNum);
		}
		return null;
	}
	
	protected Integer getSparePin(int frameNum) {
		if(frameNum == 8 && nextFrame.getFirstPin() != null)
			return nextFrame.getFirstPin();
		if (nextFrame.getFirstPin() != null)
			return nextFrame.getFirstPin();
		return null;
	}
	
	protected Integer getStrikePin(int frameNum) {
		if(frameNum == 8 &&  nextFrame.getFirstPin() != null && nextFrame.getSecondPin() != null)
			return nextFrame.getFirstPin() + nextFrame.getSecondPin();
		if (nextFrame.isStrike() && nextFrame.getNextFrameFirstPin() != null)
			return 10 + nextFrame.getNextFrameFirstPin();
		if (nextFrame.getFirstPin() != null && nextFrame.getSecondPin() != null)
			return nextFrame.getFirstPin() + nextFrame.getSecondPin();
		return null;
	}

	protected abstract Integer calcSparePin(int frameNum);
	
	protected abstract Integer calcStrikePin(int frameNum);


	public int validateAddScore(int frameNum) throws Exception {
		int score = InputView.inputScore(frameNum);
		try {
			isLeftPinExist(score);
		} catch (MyException e) {
			System.out.println(e.getErrorMessage());
			return validateAddScore(score);
		}
		return score;

	}

	protected int getScopeOfScore() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		if (totalScore == 10)
			return 1;
		if (totalScore < 10)
			return 0;
		return -1;
	}

	protected Status getStatus() {
		return Status.valueOf(getScopeOfScore(), frame.size());
	}

	protected boolean isReady() {
		return getStatus() == Status.READY;
	}

	protected boolean isMiss() {
		return (getStatus() == MISSORNORMAL) && frame.get(1) == 0;
	}

	protected boolean isNormal() {
		return (getStatus() == MISSORNORMAL && frame.get(1) != 0);
	}

	protected String getReadyResult() {
		return "\t" + frame.get(0) + " | ";
	}

	protected String getSpareResult() {
		return "/" + "\t|";
	}

	protected String getStrikeResult() {
		return "\t" + "X" + "\t| ";
	}

	protected String getMissResult() {
		return "-" + "\t|";
	}

	protected String getNormalResult() {
		return frame.get(1) + "\t|";
	}

	protected String getStatusResult() {
		if (isReady())
			return getReadyResult();

		if (isStrike()) {
			return getStrikeResult() + makeFinalStrikeResult();
		}

		if (isSpare()) {
			return getReadyResult() + getSpareResult() + makeFinalSpareResult();
		}

		if (isMiss()) {
			return getReadyResult() + getMissResult();
		}
		if (isNormal()) {
			return getReadyResult() + getNormalResult();
		}
		return "";
	}

	protected abstract boolean isSpare();

	protected abstract boolean isStrike();

	protected abstract boolean isNotEnd();

	protected abstract String makeFinalStrikeResult();

	protected abstract String makeFinalSpareResult();


	protected abstract boolean checkFrameException(int score);

	public abstract boolean isGameNotEnd();


	protected void isLeftPinExist(int score) throws MyException {
		if (checkFrameException(score))
			throw new MyException("남은 핀은 그렇게 많지 않습니다.");
	}
	public boolean isOver() {
		return frameNum > 9;
	}

}
