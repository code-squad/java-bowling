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
		scoreBoard.put(frame, (frame == 10) ? new LastFrame(frame, scoreFirstRoll)
				: (scoreFirstRoll == 10) ? new StrikeFrame(frame) : chooseFrame(frame, scoreFirstRoll));
		setTotalScoreCase();
	}

	private Frame chooseFrame(int frame, int scoreFirstRoll) {
		int scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		return ((scoreFirstRoll + scoreSecondRoll) == 10) ? new SpareFrame(frame, scoreFirstRoll, scoreSecondRoll)
				: new NormalFrame(frame, scoreFirstRoll, scoreSecondRoll);
	}

	private void setTotalScoreCase() {
		Collection<Frame> Frames = scoreBoard.values();
		for (Frame frameObject : Frames) {
			if (frameObject.getTotalSetOrNot() == false) {
				totalScore = frameObject.setGameTotalScore(scoreBoard, totalScore);
			}
		}
	}
}