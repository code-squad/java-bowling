package bowling;

import static bowling.Status.SPARE;
import static bowling.Status.STRIKE;
import static bowling.Status.NORMAL;

import java.util.ArrayList;

public class Frame {
	ArrayList<Integer> frame = new ArrayList<>();

	Frame() {

	}

	public void addScore(int score) {
		frame.add(score);
	}

	public ArrayList<Integer> getFrame() {
		return frame;
	}

	public int getFrameAt(int index) {
		return frame.get(index);
	}

	public boolean isScoreTen() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		return totalScore == 10;
	}

	public Status getStatus() {
		return Status.valueOf(isScoreTen(), frame.size());
	}

	public boolean isNotEnd() {
		return getStatus() == null;
	}

	public String changeFormat() {
		String strScore = "\t" + Integer.toString(frame.get(0));
		if (getStatus() == STRIKE)
			strScore = "\t" + STRIKE.symbol + "\t|";
		if (getStatus() == SPARE)
			strScore = " | /" + "\t|";
		if (getStatus() == NORMAL)
			strScore = " | -" + "\t|";
		return strScore;

	}

}
