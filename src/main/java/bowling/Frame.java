package bowling;

import static bowling.Status.STRIKE;

import java.util.ArrayList;

public class Frame {
	private int frameNo;
	ArrayList<Integer> pins = new ArrayList<>();
	private Frame nextFrame;
	
	Frame() {
	}

	public void addScore(int score) {
		pins.add(score);
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

	protected boolean isNotEnd() {
		return getStatus().isReady() || getStatus().isFirstshot();
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

	private String checkStrikeOrSpare(Status status) {
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
	
	public ArrayList<Integer> makeTotal(ArrayList<Integer> result) {
		for (Integer score : pins) {
			result.add(score);
		}
		return result;
	}
	
	public int makeFrameScore() {
		if (getStatus().isReady() || getStatus().isFirstshot()) {
			return 0;
		}
		return makeScore();
	}

	public int makeScore() {
		int score = 0;
		for (Integer falledPin : pins) {
			score += falledPin;
		}
		return score;
	}
}