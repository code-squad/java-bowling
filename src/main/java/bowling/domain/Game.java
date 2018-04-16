package bowling.domain;

import java.util.ArrayList;
import java.util.List;

import bowling.view.Print;

public class Game {

	private List<Frame> frames;

	public Game(List<Frame> frames) {
		this.frames = frames;
	}

	public static Game of() {
		List<Frame> frames = new ArrayList<>();
		return new Game(frames);
	}

	public void updateScore(int inputScore, Pin pin, int frameNum) {
		for (int i = 0; i < frames.size(); i++) {
			inputScore = canOnlyOneMoreCalculate(i, inputScore, pin);
			canCalculateScore(i, inputScore);
		}
	}

	public int canOnlyOneMoreCalculate(int i, int inputScore, Pin pin) {
		if (frames.get(i).canOnlyOneMoreCalculate()) {
			inputScore = calcInputScore(i, inputScore);
			calcIsBeforeStrike(i, inputScore, pin);
		}
		return inputScore;
	}

	public void canCalculateScore(int i, int inputScore) {
		if (frames.get(i).canCalucateScore()) {
			frames.get(i).updateScore(inputScore);
		}
	}

	public void calcIsBeforeStrike(int i, int inputScore, Pin pin) {
		if (i > 0 && frames.get(i - 1).isStrike()) {
			frames.get(i).updateScore(inputScore + pin.getPin(0));
		}
	}

	public int calcInputScore(int i, int inputScore) {
		if (i > 1) {
			return inputScore + inputScore;
		}
		return inputScore;
	}

	public void addFrame(int frameNum, Pin pin) {
		if (frameNum == Print.LAST_FRAME) {
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

	public int beforeScore(int frameNum) {
		if (frameNum == 1) {
			return 0;
		}
		return getScore(frameNum - 2).getScore();
	}

	public String getDownPin(int i) {
		return frames.get(i).getDownPin();
	}

}
