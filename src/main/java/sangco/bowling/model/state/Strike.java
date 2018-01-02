package sangco.bowling.model.state;

import sangco.bowling.model.Frame;
import sangco.bowling.model.state.StrikeFrame;

public class Strike extends BowlingState {
	public int getGameTotalScore(int frameScore, Frame nextFrame) {
		if(nextFrame != null && !(nextFrame.getState() instanceof Strike)) {
			return nextFrame.getTotalScore() + 10 + nextFrame.getFrameScore();
		}
		if(nextFrame != null && nextFrame.getState() instanceof Strike) {
			
			return nextFrame.getTotalScore() + 20 + nextFrame.getTwoFrameNextFirstScore();
		}
		return 0;
	}
}
