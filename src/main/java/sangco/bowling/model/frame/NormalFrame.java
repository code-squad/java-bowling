package sangco.bowling.model.frame;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class NormalFrame implements Frame {
	private int frameNumber = 0;
	private boolean totalSetOrNot = false;
	private int scoreFirstRoll = 0;
	private int scoreSecondRoll = 0;
	private int gameTotalScore = 0;

	public NormalFrame(int frameNumber, int scoreFirstRoll, int scoreSecondRoll) {
		this.frameNumber = frameNumber;
		this.scoreFirstRoll = scoreFirstRoll;
		this.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(HashMap<Integer, Frame> scoreBoard, int totalScore) {
		totalSetOrNot = true;
		gameTotalScore = totalScore + getScoreFrame();
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