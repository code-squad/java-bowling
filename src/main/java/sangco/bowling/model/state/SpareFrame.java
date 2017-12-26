package sangco.bowling.model.state;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class SpareFrame extends Frame {
	public SpareFrame() {
		super();
	}

	public SpareFrame(int frameIndex, int scoreFirstRoll, int scoreSecondRoll) {
		super.frameNumber = frameIndex;
		super.scoreFirstRoll = scoreFirstRoll;
		super.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		if(nextFrame != null) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + nextFrame.getScoreFirstRoll();
		}
		return gameTotalScore;
	}
}
