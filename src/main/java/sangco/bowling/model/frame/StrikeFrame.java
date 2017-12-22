package sangco.bowling.model.frame;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class StrikeFrame implements Frame {
	private int frameNumber = 0;
	private boolean totalSetOrNot = false;
	private final int scoreFirstRoll = 10;
	private final int scoreSecondRoll = 0;
	private int gameTotalScore = 0;

	public StrikeFrame(int frameNumber) {
		this.frameNumber = frameNumber;
	}

	@Override
	public int getGameTotalScore() {
		return gameTotalScore;
	}

	@Override
	public int setGameTotalScore(HashMap<Integer, Frame> scoreBoard, int totalScore) {
		int oneFrameNext = frameNumber + 1;
		int twoFrameNext = frameNumber + 2;

		if (oneFrameNext == scoreBoard.size() && scoreBoard.get(oneFrameNext) instanceof LastFrame) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + scoreBoard.get(oneFrameNext).getScoreFrame();
			return gameTotalScore;
		}
		if (oneFrameNext == scoreBoard.size() && !(scoreBoard.get(oneFrameNext) instanceof StrikeFrame)) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + scoreBoard.get(oneFrameNext).getScoreFrame();
			return gameTotalScore;
		}
		if (twoFrameNext == scoreBoard.size() && scoreBoard.get(oneFrameNext) instanceof StrikeFrame) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 20 + scoreBoard.get(twoFrameNext).getScoreFirstRoll();
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
