package bowling.domain;

import java.util.ArrayList;
import java.util.List;
import bowling.view.Print;

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

	public boolean addScore(int inputScore, int frameNum, String name) {
		oneBall.addScore(inputScore);
		updateScore(inputScore, oneBall, frameNum);
		Print.printFrame(oneBall, name, frameNum, this);
		return canNextFrame(frameNum, oneBall);
	}

	private Boolean canNextFrame(int frameNum, Pin pin) {
		if ((frameNum != Game.LAST_FRAME && (Pin.isStrike(pin.getPin(0)) || pin.size() == 2))
				|| (frameNum == Game.LAST_FRAME && pin.checkNotThird())) {
			addFrame(frameNum, oneBall);
			resetPin();
			return false;
		}
		return true;
	}

	private void updateScore(int inputScore, Pin pin, int frameNum) {
		for (int i = 0; i < frames.size(); i++) {
			inputScore = canOnlyOneMoreCalculate(i, inputScore, pin);
			canCalculateScore(i, inputScore);
		}
	}

	private int canOnlyOneMoreCalculate(int i, int inputScore, Pin pin) {
		if (frames.get(i).canOnlyOneMoreCalculate()) {
			inputScore = calcInputScore(i, inputScore);
			calcIsBeforeStrike(i, inputScore, pin);
		}
		return inputScore;
	}

	private void canCalculateScore(int i, int inputScore) {
		if (frames.get(i).canCalucateScore()) {
			frames.get(i).updateScore(inputScore);
		}
	}

	private void calcIsBeforeStrike(int i, int inputScore, Pin pin) {
		if (i > 0 && frames.get(i - 1).isStrike()) {
			frames.get(i).updateScore(inputScore + pin.getPin(0));
		}
	}

	private int calcInputScore(int i, int inputScore) {
		if (i > 1 && inputScore == Pin.STRIKE) {
			return inputScore + inputScore;
		}
		return inputScore;
	}

	public void addFrame(int frameNum, Pin pin) {
		if (frameNum == LAST_FRAME) {
			frames.add(LastFrame.of(pin, beforeScore(frameNum)));
			return;
		}
		frames.add(NormalFrame.of(pin, beforeScore(frameNum)));
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
