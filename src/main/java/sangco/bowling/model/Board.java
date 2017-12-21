package sangco.bowling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sangco.bowling.model.frame.Frame;
import sangco.bowling.model.frame.LastFrame;
import sangco.bowling.model.frame.NormalFrame;
import sangco.bowling.model.frame.SpareFrame;
import sangco.bowling.model.frame.StrikeFrame;
import sangco.bowling.view.InputView;

public class Board {
	HashMap<Integer, Frame> scoreBoard = new HashMap<>();;
	int totalScore = 0;

	public void createFrame(int frame, int scoreFirstRoll) {
		scoreBoard.put(frame, (frame == 10) ? new LastFrame(scoreFirstRoll)
				: (scoreFirstRoll == 10) ? new StrikeFrame() : chooseFrame(scoreFirstRoll));
		setTotalScoreCase(frame);
	}

	private Frame chooseFrame(int scoreFirstRoll) {
		int scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		return ((scoreFirstRoll + scoreSecondRoll) == 10) ? new SpareFrame(scoreFirstRoll, scoreSecondRoll)
				: new NormalFrame(scoreFirstRoll, scoreSecondRoll);
	}

	private void setTotalScoreCase(int frame) {
		int twoFrameAgo = frame-2;
		int oneFrameAgo = frame-1;
		
		if (frame >= 3 && scoreBoard.get(twoFrameAgo) instanceof StrikeFrame
				&& scoreBoard.get(twoFrameAgo).getTotalSetOrNot() == false) {
			totalScore = ((StrikeFrame) scoreBoard.get(twoFrameAgo)).setTripleStrikeScore(frame, scoreBoard, totalScore);
		}
		if (frame >= 2 && scoreBoard.get(oneFrameAgo).getScoreFrame() == 10
				&& scoreBoard.get(oneFrameAgo).getTotalSetOrNot() == false) {
			totalScore = scoreBoard.get(oneFrameAgo).setGameTotalScore(frame, scoreBoard, totalScore);
		}
		if (scoreBoard.get(frame) instanceof NormalFrame && scoreBoard.get(frame).getTotalSetOrNot() == false) {
			totalScore = scoreBoard.get(frame).setGameTotalScore(frame, scoreBoard, totalScore);
		}
		if (scoreBoard.get(frame) instanceof LastFrame) {
			totalScore = scoreBoard.get(frame).setGameTotalScore(frame, scoreBoard, totalScore);
		}
	}
}