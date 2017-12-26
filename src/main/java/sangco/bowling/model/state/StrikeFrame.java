package sangco.bowling.model.state;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class StrikeFrame extends Frame {
	public StrikeFrame() {
		super();
	}
	
	public StrikeFrame(int frameIndex, int scoreFirstRoll, int scoreSecondRoll) {
		super.frameNumber = frameIndex;
		super.scoreFirstRoll = scoreFirstRoll;
		super.scoreSecondRoll = scoreSecondRoll;
	}

	@Override
	public int setGameTotalScore(int totalScore) {
		if(nextFrame != null && !(nextFrame instanceof StrikeFrame)) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 10 + nextFrame.getFrameScore();
			return gameTotalScore;
		}
		if(nextFrame != null && nextFrame instanceof StrikeFrame) {
			totalSetOrNot = true;
			gameTotalScore = totalScore + 20 + nextFrame.getTwoFrameNextFirstScore();
			return gameTotalScore;
		}
		return totalScore;
	}
}
