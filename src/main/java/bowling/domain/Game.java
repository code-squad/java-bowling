package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static final int LAST_FRAME = 10;
	private List<Frame> frames;
	private Pin oneBall;

	private Game(List<Frame> frames) {
		this.oneBall = Pin.of();
		this.frames = frames;
	}

	public static Game of() {
		List<Frame> frames = new ArrayList<>();
		return new Game(frames);
	}

	public void resetPin() {
		this.oneBall = Pin.of();
	}

	public Pin getOneBall() {
		return oneBall;
	}

	public Pin addScore(int inputScore) {
		oneBall.addScore(inputScore);
		updateScore(inputScore);
		return oneBall;
	}

	public Boolean canNextFrame(int frameNum) {
		if ((frameNum != Game.LAST_FRAME && (Pin.isStrike(oneBall.getPin(0)) || oneBall.size() == 2))
				|| (frameNum == Game.LAST_FRAME && oneBall.checkNotThird())) {
			addFrame(frameNum);
			resetPin();
			return false;
		}
		return true;
	}

	private void updateScore(int inputScore) {
		for (int i = 0; i < frames.size(); i++) {
			inputScore = canOnlyOneMoreCalculate(i, inputScore);
			canCalculateScore(i, inputScore);
		}
	}

	private int canOnlyOneMoreCalculate(int i, int inputScore) {
		if (frames.get(i).canOnlyOneMoreCalculate()) {
			inputScore = calcInputScore(i, inputScore);
			calcIsBeforeStrike(i, inputScore);
		}
		return inputScore;
	}

	private void canCalculateScore(int i, int inputScore) {
		if (frames.get(i).canCalucateScore()) {
			frames.get(i).updateScore(inputScore);
		}
	}

	private void calcIsBeforeStrike(int i, int inputScore) {
		if (i > 0 && frames.get(i - 1).isStrike()) {
			frames.get(i).updateScore(inputScore + oneBall.getPin(0));
		}
	}

	private int calcInputScore(int i, int inputScore) {
		if (i > 1 && inputScore == Pin.STRIKE) {
			return inputScore + inputScore;
		}
		return inputScore;
	}

	public void addFrame(int frameNum) {
		if (frameNum == LAST_FRAME) {
			frames.add(LastFrame.of(oneBall, beforeScore(frameNum)));
			return;
		}
		frames.add(NormalFrame.of(oneBall, beforeScore(frameNum)));
	}

	public int size() {
		return frames.size();
	}

	public Score getScore(int i) {
		return frames.get(i).getScore();
	}

	public int getLastScore() {
		return getScore(frames.size() - 1).getScore();
	}

	private int beforeScore(int frameNum) {
		if (frameNum == 1) {
			return 0;
		}
		if (frameNum == 10) { // for testCode
			return getLastScore();
		}
		return getScore(frameNum - 2).getScore();
	}

	public String getDownPin(int i) {
		return frames.get(i).getDownPin();
	}

}
