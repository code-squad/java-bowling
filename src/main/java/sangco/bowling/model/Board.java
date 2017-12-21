package sangco.bowling.model;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.model.frame.Frame;
import sangco.bowling.model.frame.LastFrame;
import sangco.bowling.model.frame.NormalFrame;
import sangco.bowling.model.frame.SpareFrame;
import sangco.bowling.model.frame.StrikeFrame;
import sangco.bowling.view.InputView;

public class Board {
	private HashMap<Integer, Frame> scoreBoard = new HashMap<>();;
	private int totalScore = 0;

	private Boolean strike = false;
	private Boolean spare = false;
	private Boolean doubleStrike = false;

	public void createFrame(int frame, int scoreFirstRoll) {
		scoreBoard.put(frame, (frame == 10) ? new LastFrame(scoreFirstRoll)
				: (scoreFirstRoll == 10) ? new StrikeFrame() : chooseFrame(scoreFirstRoll));
		setTotalScoreCase(frame, scoreFirstRoll);
	}

	private Frame chooseFrame(int scoreFirstRoll) {
		int scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		return ((scoreFirstRoll + scoreSecondRoll) == 10) ? new SpareFrame(scoreFirstRoll, scoreSecondRoll)
				: new NormalFrame(scoreFirstRoll, scoreSecondRoll);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	private void setTotalScoreCase(int frame, int scoreFirstRoll) {
		if (doubleStrike == true) {
			setDoubleStrikeFrame(frame, scoreFirstRoll);
		}
		if (strike == true && scoreBoard.get(frame).getScoreFirstRoll() != 10) {
			setStrikeFrame(frame, scoreFirstRoll);
		}
		if (spare == true) {
			setSpareFrame(frame, scoreFirstRoll);
		}
		if (scoreBoard.get(frame) instanceof NormalFrame) {
			setNomalFrame(frame, scoreFirstRoll);
		}
		
		setBooleanData(frame);
		
		if (frame == 10) {
			setLastFrame(frame, scoreFirstRoll);
		}
	}

	private void setLastFrame(int frame, int scoreFirstRoll) {
		if (doubleStrike == true) {
			setDoubleStrikeLastFrame(frame, scoreFirstRoll);
		}
		totalScore = scoreBoard.get(frame).setGameTotalScore(totalScore, scoreFirstRoll);
	}

	private void setNomalFrame(int frame, int scoreFirstRoll) {
		totalScore = scoreBoard.get(frame).setGameTotalScore(totalScore, scoreFirstRoll);
	}

	private void setSpareFrame(int frame, int scoreFirstRoll) {
		totalScore = scoreBoard.get(frame - 1).setGameTotalScore(totalScore, scoreFirstRoll);
		spare = false;
	}

	private void setStrikeFrame(int frame, int scoreFirstRoll) {
		totalScore = ((StrikeFrame) scoreBoard.get(frame - 1)).setGameTotalScoreStrike(totalScore, scoreFirstRoll,
				scoreBoard.get(frame).getScoreSecondRoll());
		if (!(scoreBoard.get(frame) instanceof StrikeFrame)) {
			strike = false;
		}
	}

	private void setDoubleStrikeFrame(int frame, int scoreFirstRoll) {
		totalScore = scoreBoard.get(frame - 2).setGameTotalScore(totalScore, scoreFirstRoll);
		doubleStrike = false;
	}
	
	private void setDoubleStrikeLastFrame(int frame, int scoreFirstRoll) {
		totalScore = scoreBoard.get(frame - 1).setGameTotalScore(totalScore, scoreFirstRoll);
		doubleStrike = false;
	}

	private void setBooleanData(int frame) {
		if (doubleStrike == false && strike == true && scoreBoard.get(frame).getScoreFirstRoll() == 10) {
			doubleStrike = true;
		}
		if (scoreBoard.get(frame) instanceof StrikeFrame) {
			strike = true;
		}
		if (scoreBoard.get(frame) instanceof SpareFrame) {
			spare = true;
		}
	}
}