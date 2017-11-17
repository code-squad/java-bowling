package model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exception.InvalidFrameException;
import model.frame.Frame;

public class SetOfFrame {

	private List<Frame> fullFrame = new ArrayList<Frame>();
	private int currentFrameIndex = 0;
	private int maxFrame;
	private boolean isNextFrame = false;

	public void shot(int score) {
		isNextFrame = false;
		currentFrame().shot(score);
		addBonusScore(score);
		if (isEndCurrentFrame()) {
			isNextFrame = true;
			currentFrameIndex++;
		}
	}

	public SetOfFrame(int numFrame) {
		maxFrame = numFrame;
		for (int i = 0; i < numFrame - 1; i++) {
			fullFrame.add(new NormalFrame());
		}
		fullFrame.add(new LastFrame());
	}

	public boolean isNextFrame() {
		return isNextFrame;
	}

	private void addBonusScore(int score) {
		if (currentFrameIndex > 1)
			checkAddBonusScore(get(currentFrameIndex - 2), score);
		if (currentFrameIndex > 0)
			checkAddBonusScore(get(currentFrameIndex - 1), score);
	}

	private void checkAddBonusScore(Frame previousFrame, int score) {
		previousFrame.addBonusScore(score);
	}

	public int getCurrentFrameIndex() {
		return currentFrameIndex;
	}

	private Frame currentFrame() {
		return get(currentFrameIndex);
	}

	private Frame get(int index) throws InvalidFrameException {
		if (index >= maxFrame)
			throw new InvalidFrameException("최대 프레임을 벗어났습니다.");
		return fullFrame.get(index);
	}

	public boolean isEndCurrentFrame() {
		return currentFrame().isEndFrame();
	}

	public int getTotalScore() {
		return fullFrame.stream().mapToInt(Frame::getFrameScore).sum();
	}

	public String getCurrentScoreBoard() {
		return fullFrame.stream().map(Frame::getCurrentScoreBoard).map(s -> String.format("%6s", s + " "))
				.collect(Collectors.joining("|"));
	}

	public String getCurrentFrameScoreBoard() {
		String currentFrameScoreBoard = "";
		for (int i = 0; i < maxFrame; i++) {
			currentFrameScoreBoard += getEndFrameScoreBoard(i);
		}
		return currentFrameScoreBoard;
	}

	public String getEndFrameScoreBoard(int index) {
		if (!get(index).isEndFrame() || get(index).isBonusAddCount()) {
			return String.format("%6s", " ") + "|";
		}
		return String.format("%6s", getCurrentFrameScore(index + 1) + " ") + "|";
	}

	private String getCurrentFrameScore(int index) {
		int currentFrameScore = 0;
		for (int i = 0; i < index; i++) {
			currentFrameScore += fullFrame.get(i).getFrameScore();
		}
		return Integer.toString(currentFrameScore);
	}
}