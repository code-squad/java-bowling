package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidFrameException;

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
			fullFrame.add(new Frame());
		}
		fullFrame.add(new LastFrame());
	}
	
	public boolean isNextFrame() {
		return isNextFrame;
	}

	// 첫번째 두번째 프레임에서는 존재하지 않은 인덱스를 선택하지 않도록 한다.
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
}
