package bowling;

import static bowling.Status.STRIKE;
import static bowling.Status.MISSORNORMAL;
import static bowling.Status.FIRSTSHOT;
import static bowling.Status.READY;

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
		return getStatus() == READY || getStatus() == FIRSTSHOT;
	}

	protected String changeFormat() {
		String strScore = "" + frame.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
			return strScore;
		}
		if (getStatus() == MISSORNORMAL) {
			strScore = checkMissOrNormal(frame.get(frame.size() - 1));
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
		return "" + frame.get(frame.size() - 1);
	}

	protected String isFirstOrNot(String convertedScore) {
		if (frame.size() > 1) {
			return frame.get(0) + "|" + convertedScore;
		}
		return convertedScore;
	}
	protected int checkSecondIsRight() {
		if (getStatus() == Status.FIRSTSHOT) {
			return frame.get(frame.size() - 1);
		}
		return 0;
	}
}