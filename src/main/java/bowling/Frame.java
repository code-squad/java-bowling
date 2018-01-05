package bowling;

import static bowling.Status.STRIKE;

import java.util.ArrayList;

public class Frame {
	private int frameNo;
	ArrayList<Integer> pins = new ArrayList<>();
	private Frame nextFrame;

	Frame(int frameNo) {
		this.frameNo = frameNo;
	}

	public int getFrameNo() {
		return this.frameNo;
	}

	public Frame addScore(int falledPin) {
		if (isNotEnd()) {
			pins.add(falledPin);
			return this;
		}

		if (this.frameNo == 9) {
			this.nextFrame = new FinalFrame(frameNo + 1);
			return nextFrame;
		}

		this.nextFrame = new Frame(frameNo + 1);
		return nextFrame;
	}

	protected boolean isNotEnd() {
		return getStatus().isReady() || getStatus().isFirstshot();
	}

	protected boolean isPinClear() {
		int totalScore = 0;
		for (int i = 0; i < pins.size(); i++) {
			totalScore += pins.get(i);
		}
		return totalScore % 10 == 0 && totalScore != 0;
	}

	protected Status getStatus() {
		return Status.valueOf(isPinClear(), pins.size());
	}

	protected String changeFormat() {
		String strScore = "" + pins.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
			return strScore;
		}
		if (getStatus().isMissOrNormal()) {
			strScore = checkMissOrNormal(getLastData());
		}

		return isFirstOrNot(strScore);
	}

	protected String checkStrikeOrSpare(Status status) {
		if (status == STRIKE) {
			return "X";
		}
		return pins.get(0) + "|/";
	}

	protected String checkMissOrNormal(int secondShotScore) {
		if (secondShotScore == 0) {
			return  "-";
		}
		return "" + getLastData();
	}

	protected String isFirstOrNot(String convertedScore) {
		if (pins.size() > 1) {
			return pins.get(0) + "|" + convertedScore;
		}
		return convertedScore;
	}

	protected int checkSecondIsRight() {
		if (getStatus().isFirstshot()) {
			return getLastData();
		}
		return 0;
	}

	protected int getLastData() {
		return pins.get(pins.size() - 1);
	}
	
	public int makeFrameScore() {
		int frameScore = makeScore();
		Score score = new Score(frameScore, bonusTryNum());
		
		if (isPinClear() && nextFrame != null) {
			score = nextFrame.addBonusScore(score);
		}
		return score.getScore();
	}
	
	private Score addBonusScore(Score score) {
		int count = 0;
		while (!score.isEnded() && count < pins.size()) {
			score.bowl(pins.get(count));
			count++;
		}
		if (!score.isEnded() && nextFrame != null) {
			score = nextFrame.addBonusScore(score);
			return score;
		}
		return score;
	}
	
	private int makeScore() {
		int score = 0;
		for (Integer falledPin : pins) {
			score += falledPin;
		}
		return score;
	}
	
	private int bonusTryNum() {
		if (getStatus().isStrike()) {
			return 2;
		}
		if (getStatus().isSpare()) {
			return 1;
		}
		return 0;
	}
}