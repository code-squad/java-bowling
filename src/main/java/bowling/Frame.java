package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Frame {
	private int frameNum;
	private ArrayList<Integer> frame = new ArrayList<>();
	private Frame nextFrame;
	private Score frameScore;

	public Frame(int frameNum) {
		this.frameNum = frameNum;
	}

	protected ArrayList<Integer> getFrame() {
		return frame;
	}
	
	protected int getFrameNum(){
		return frameNum;
	}

	public boolean isAddPossible(HashMap<Integer, Frame> frames) {

		if (frames.get(frameNum) != null)
			return frames.get(frameNum) == this;
		return true;
	}

	public void addFrames(HashMap<Integer, Frame> frames) {

		frames.put(frameNum, this);
	}

	protected boolean isFrameEmpty() {
		return frame.isEmpty();
	}

	protected int getFrameSize() {
		return frame.size();
	}

	public Frame addScore(int score) {
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

	protected int getFirstPin() {
		return frame.get(0);
	}

	protected int getSecondPin() {
		return frame.get(1);
	}

	protected int getBonusPin() {
		return frame.get(2);
	}

	protected Integer getNextFrameFirstPin() {
		if (nextFrame.getFrameSize() >= 1)
			return nextFrame.getFirstPin();
		return null;
	}

	public Score calcScore() {
		if (isNotEnd())
			return null;

		frameScore = createScore();

		if (frameScore.isEnded()) {
			return frameScore;
		}
		if(frameNum == 9 && frame.size() == 3){
			return addNextScore(frameScore, frameNum);
		}
		if (nextFrame != null) {
			return nextFrame.addNextScore(frameScore, frameNum);
		}
		return null;
	}
	
	protected Score addNextScore(Score frameScore, int frameNum) {
		for (Integer score : frame) {
			if (!frameScore.isEnded())
				frameScore.bowl(score);
		}
		if (frameScore.isEnded())
			return frameScore;
		if (nextFrame != null)
			return nextFrame.addNextScore(frameScore, frameNum);
		return null;
		
	}

	private Score createScore() {
		if (getStatus() == Status.MISSORNORMAL) {
			return new Score(getFirstPin() + getSecondPin(), 0);
		}
		return new Score(10, createBonusNum());
	}

	protected int createBonusNum() {
		if (isSpare())
			return 1;
		if (isStrike())
			return 2;
		return 0;
	}
	
//	private int createStartPin(){
//		if(frameNum == 9)
//			return 0;
//		return 10;
//	}

	public void getFrameScore(ArrayList<Integer> total) {
		if (calcScore() != null)
			total.add(calcScore().getFrameScore());
	}

	protected Score calcSparePin(Score frameScore) {
		return nextFrame.addFirstScore(frameScore);
	}

	protected void calcStrikePin(Score frameScore) {
		if (nextFrame.isStrike() && frameNum != 8) {
			nextFrame.addFirstScore(frameScore);
			nextFrame.addNextFrameScore(frameScore);
		}
		if (nextFrame.getFrameSize() >= 2) {
			nextFrame.addFirstScore(frameScore);
			nextFrame.addSecondScore(frameScore);
		}
	}

	protected Score addFirstScore(Score frameScore) {
		if (frame.size() >= 1)
			frameScore.bowl(getFirstPin());
		return frameScore;
	}

	protected void addSecondScore(Score frameScore) {
		if (frame.size() >= 2)
			frameScore.bowl(getSecondPin());
	}

	protected Score addThirdScore(Score frameScore) {
		if (frame.size() == 3)
			frameScore.bowl(getBonusPin());
		return frameScore;
	}

	protected void addNextFrameScore(Score frameScore) {
		if (nextFrame != null && nextFrame.getFrameSize() >= 1)
			nextFrame.addFirstScore(frameScore);
	}

	public Integer validateAddScore(int score) throws Exception {
		try {
			isLeftPinExist(score);
		} catch (MyException e) {
			System.out.println(e.getErrorMessage());
			return null;
		}
		return score;

	}

	private int getScopeOfScore() {
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

	private String getReadyResult() {
		return "\t" + frame.get(0) + " | ";
	}

	private String getSpareResult() {
		return "/" + "\t|";
	}

	private String getStrikeResult() {
		return "\t" + "X" + "\t| ";
	}

	private String getMissResult() {
		return "-" + "\t|";
	}

	private String getNormalResult() {
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

	protected boolean isStrike() {
		if (frame.size() >= 1)
			return isFinalStrikeOrSpare() && getFirstPin() == 10;
		return false;
	}

	protected boolean isSpare() {
		if (getFrameSize() >= 2)
			return isFinalStrikeOrSpare() && (getFirstPin() + getSecondPin() == 10);
		return false;
	}

	protected abstract boolean isFinalStrikeOrSpare();

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
