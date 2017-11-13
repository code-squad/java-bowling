package bowling.frame.state.nomalFrame;

import bowling.frame.state.End;

public class NomalFrameStrike extends End {

	@Override
	public String getPresentScore() {
		return "X";
	}

}
