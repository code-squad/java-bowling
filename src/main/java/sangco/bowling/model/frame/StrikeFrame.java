package sangco.bowling.model.frame;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class StrikeFrame implements Frame {
	private final int scoreFirstRoll = 10;
	private final int scoreSecondRoll = 0;
	private int gameTotalScore = 0;
	private boolean totalSetOrNot = false;

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(int frame, HashMap<Integer, Frame> scoreBoard, int totalScore) {
		if (scoreBoard.get(frame).getScoreFirstRoll() != 10) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + scoreBoard.get(frame).getScoreFrame();
			return gameTotalScore;
		}
		if (scoreBoard.get(frame) instanceof LastFrame) { 
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + scoreBoard.get(frame).getScoreFrame();
			return gameTotalScore;
		}
		return totalScore;
	}
	
	public int setTripleStrikeScore(int frame, HashMap<Integer, Frame> scoreBoard, int totalScore) {
		totalSetOrNot = true;
		gameTotalScore = totalScore + 20 + scoreBoard.get(frame).getScoreFirstRoll();
		return gameTotalScore;
	}

	@Override
	public int getScoreFirstRoll() {
		return scoreFirstRoll;
	}

	@Override
	public int getScoreSecondRoll() {
		return scoreSecondRoll;
	}

	@Override
	public int getScoreFrame() {
		return scoreFirstRoll + scoreSecondRoll;
	}

	@Override
	public boolean getTotalSetOrNot() {
		return totalSetOrNot;
	}
}
