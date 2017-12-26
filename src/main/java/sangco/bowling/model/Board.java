package sangco.bowling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sangco.bowling.model.state.Frame;
import sangco.bowling.model.state.LastFrame;
import sangco.bowling.model.state.NormalFrame;
import sangco.bowling.model.state.SpareFrame;
import sangco.bowling.model.state.StrikeFrame;
import sangco.bowling.view.InputView;

public class Board {
	ArrayList<Frame> scoreBoard = new ArrayList<>();
	private int totalScore = 0;
	
	public void createFrame(int frameIndex, int firstRoll, int secondRoll) {
		Frame frameObject = frameFactory(frameIndex, firstRoll, secondRoll);
		scoreBoard.add(frameObject);
		if (scoreBoard.size() >= 2) {
			int beforeFrame = frameIndex - 1;
			scoreBoard.get(beforeFrame).setNextFrame(frameObject);
		}
		totalScore = setTotalScore(totalScore);
	}

	private Frame frameFactory(int frameIndex, int firstRoll, int secondRoll) {
		if (isLastFrame(frameIndex)) {
			return new LastFrame(frameIndex, firstRoll);
		}
		if (isStrike(firstRoll) == true) {
			return new StrikeFrame(frameIndex);
		}
		if (isSpare(firstRoll, secondRoll) == true) {
			return new SpareFrame(frameIndex, firstRoll, secondRoll);
		}
		return new NormalFrame(frameIndex, firstRoll, secondRoll);
	}

	private boolean isStrike(int firstRoll) {
		return firstRoll == 10;
	}

	private boolean isSpare(int firstRoll, int secondRoll) {
		return firstRoll + secondRoll == 10;
	}

	private boolean isLastFrame(int frameIndex) {
		return frameIndex == 10;
	}

	private int setTotalScore(int totalScore) {
		for (Frame frame : scoreBoard) {
			if (frame.getTotalSetOrNot() == false) {
				return totalScore = frame.setGameTotalScore(totalScore);
			}
		}
		return totalScore;
	}
}