package bowling;

import static bowling.Status.STRIKE;

import java.util.ArrayList;

public class Frame {

	ArrayList<Integer> frame = new ArrayList<>();

	Frame() {

	}

	public void addScore(int score) {
		frame.add(score);
	}

	protected boolean isPinClear() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		return totalScore % 10 == 0 && totalScore != 0;
	}

	protected Status getStatus() {
		return Status.valueOf(isPinClear(), frame.size());
	}

	protected boolean isNotEnd() {
		return getStatus().isReady() || getStatus().isFirstshot();
	}

	protected String changeFormat() {
		String strScore = "" + frame.get(0);
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
		return frame.get(0) + "|/";
	}

	protected String checkMissOrNormal(int secondShotScore) {
		if (secondShotScore == 0) {
			return  "-";
		}
		return "" + getLastData();
	}

	protected String isFirstOrNot(String convertedScore) {
		if (frame.size() > 1) {
			return frame.get(0) + "|" + convertedScore;
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
		return frame.get(frame.size() - 1);
	}

	public int makeTotalScore(int score) {
		for (Integer integer : frame) {
			score += integer;
		}
		return score;
	}
}