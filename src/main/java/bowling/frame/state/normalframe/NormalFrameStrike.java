package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameStrike extends End {

	@Override
	public String getPresentScore() {
		return "X";
	}

	@Override
	public int getFinalScore() {
		return 10;
	}

}
