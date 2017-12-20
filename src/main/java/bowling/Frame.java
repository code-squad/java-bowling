package bowling;


import java.util.ArrayList;

public abstract class Frame {
	ArrayList<Integer> frame = new ArrayList<>();


	public void addScore(int score) {
		frame.add(score);
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

	public abstract boolean isNotEnd();

	public abstract String changeFormat();

}
