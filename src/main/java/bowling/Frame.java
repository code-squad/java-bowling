package bowling;

import static bowling.Status.STRIKE;
import static bowling.Status.SPARE;
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
		return totalScore % 10 == 0;
	}

	public Status getStatus() {
		return Status.valueOf(isPinClear(), frame.size());
	}

	public boolean isNotEnd() {
		return getStatus() == READY || getStatus() == FIRSTSHOT;
	}

	public String changeFormat() {
		String strScore = "\t" + frame.get(0);
		if (getStatus() == STRIKE)
			strScore = "\t" + "X" + "\t|";
		if (getStatus() == SPARE)
			strScore = " | /" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) == 0)
			strScore = " | -" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) != 0)
			strScore = " | " + frame.get(1) + "\t|";
		return strScore;
	}
}