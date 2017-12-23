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

	public boolean isPinClear() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		return totalScore == 10;
	}

	protected Status getStatus() {
		return Status.valueOf(isPinClear(), frame.size());
	}

	public boolean isNotEnd() {
		return getStatus() == READY || getStatus() == FIRSTSHOT;
	}

	public String changeFormat() {
		String strScore = "" + frame.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
		}
		if (getStatus() == MISSORNORMAL) {
			strScore = checkMissOrNormal(frame.get(1));
		}

		return isFirstOrNot(strScore);
	}

	protected String checkStrikeOrSpare(Status status) {
		if (status == STRIKE) {
			return "X";
		}
		return "/";
	}

	protected String checkMissOrNormal(int secondShotScore) {
		if (secondShotScore == 0) {
			return  "-";
		}
		return "" + frame.get(1);
	}

	protected String isFirstOrNot(String string) {
		if (frame.size() > 1) {
			return "|" + string;
		}
		return string;
	}
}