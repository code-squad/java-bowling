package bowling.model;

import java.util.List;

public class Frame {
	protected Frame nextFrame;
	protected Score score;
	protected int round;
	protected boolean isStrike;
	protected boolean isSpare;
	protected boolean endFrame;

	public Frame() {
		score = new Score();
		round = 1;
		isStrike = false;
		isSpare = false;
		endFrame = false;
	}

	public int size() {
		if (nextFrame == null) {
			return 1;
		}
		return 1 + nextFrame.size();
	}

	public void addFrame(Frame frame) {
		if (nextFrame == null) {
			nextFrame = frame;
			return;
		}
		nextFrame.addFrame(frame);
	}

	public int setScore(String knockedPins) {
		if (isEndFrame() || isStrike()) {
			return nextFrame.setScore(knockedPins);
		}
		score.setScore(knockedPins);
		checkStrike(knockedPins);
		checkSpare();
		return checkEndFrame();
	}

	protected void checkSpare() {
		if (score.getScore() == 10 && round == 2) {
			isSpare = true;
		}
	}

	protected boolean isSpare() {
		return isSpare;
	}

	protected void checkStrike(String knockedPins) {
		if (knockedPins.equals("10")) {
			isStrike = true;
		}
	}

	protected boolean isStrike() {
		return isStrike;
	}

	protected int checkEndFrame() {
		if (round == 2 || isStrike()) {
			endThisFrame();
			return 1;
		}
		round++;
		return 0;
	}

	protected void endThisFrame() {
		endFrame = true;
	}

	protected boolean isEndFrame() {
		return endFrame;
	}

	public String getSumScore() {
		if (!nextFrame.isEndFrame()) {
			return score.getSumScore();
		}
		return nextFrame.getSumScore();
	}

	protected int getScore() {
		return score.getScore();
	}

	public void getKnockedPins(List<String> knockedPins, List<String> intScores) {
		score.getKnockedPins(knockedPins, intScores);
		if (isNextFrame()) {
			nextFrame.getKnockedPins(knockedPins, intScores);
		}
	}

	public void calculateSumScore() {
		if (!nextFrame.isEndFrame()) {
			calculateSumScore(score.calculateSumScore("first"));
			return;
		}
		if (isEndFrame()) {
			calculateSumScore(score.calculateSumScore(score.getSumScore()));
		}
	}

	protected void calculateSumScore(String sumScore) {
		if (isEndFrame()) {
			if (isSpare()) {
				if (nextFrame.round == 2 || nextFrame.isStrike()) {
					calculateSpecial(sumScore, nextFrame.firstRoundScore());
				}
				return;
			}
			if (isStrike()) {
				if (nextFrame.isEndFrame() && !nextFrame.isStrike()) {
					calculateSpecial(sumScore, nextFrame.getScore());
					nextFrame.calculateSumScore(score.getSumScore());
					return;
				}
				if (nextFrame.isEndFrame() && nextFrame.nextFrame != null && nextFrame.nextFrame.isEndFrame()) {
					calculateSpecial(sumScore, nextFrame.nextFrame.firstRoundScore() + 10);
					nextFrame.calculateSumScore(score.getSumScore());
					return;
				}
				return;
			}
			score.calculateSumScore(sumScore);
		}
		if (isNextFrame()) {
			nextFrame.calculateSumScore(score.getSumScore());
			return;
		}
	}
	
	protected int firstRoundScore() {
		return score.firstRoundScore();
	}

	private void calculateSpecial(String sumScore, int nextFrameScore) {
		score.calculateSumScore(sumScore);
		score.calculateSpecial(nextFrameScore);
		isStrike = false;
		isSpare = false;
	}

	protected boolean isNextFrame() {
		return nextFrame != null;
	}
}
