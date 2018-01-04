package bowling;

import java.util.ArrayList;

public class Score {
	private ArrayList<Integer> score = new ArrayList<Integer> ();
	int additionalTry;
	private Score nextScore;
	
	public Score(Frame frame) {
		this.score.addAll(frame.pin);
		this.additionalTry = makeAdditionalTryNum(frame.getStatus());
		
		while (isNullStringNeeded(frame)) {
			score.add(null);
		}
	}
	
	private int makeAdditionalTryNum(Status status) {
		if (status.isStrike()) {
			return 2;
		}
		if (status.isSpare()) {
			return 1;
		}
		if (status.isMissOrNormal()) {
			return 0;
		}
		return 0;
	}
	
	private boolean isNullStringNeeded(Frame frame) {
		return score.size() < 3 && (frame.getStatus().isSpare() || frame.getStatus().isStrike());
	}
	
	public Integer getFrameScore() {
		int frameScore = 0;
		if (!score.contains(null)) {
			frameScore = makeFrameScore();
			return frameScore;
		}
		return null;
	}
	
	private int makeFrameScore() {
		int count = 0;
		for (int i = 0; i < score.size(); i++) {
			count += score.get(i);
		}
		return count;
	}
}
