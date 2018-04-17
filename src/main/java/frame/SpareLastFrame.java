package frame;

import java.util.List;

import bowling.FrameInfo;
import bowling.TotalScore;
import state.FirstRoll;
import state.Ready;
import state.State;
import state.Strike;

public class SpareLastFrame implements Frame {

	private State state;

	public SpareLastFrame() {
		this.state = new Ready();
	}

	@Override
	public Frame roll(int pinsDown) {
		state = state.update(pinsDown);
		return this;
	}
	
	@Override
	public List<FrameInfo> getFrameInfo(List<FrameInfo> frameInfoList) {
		frameInfoList.add(state.setPinsDown(new FrameInfo(10)));
		return frameInfoList;
	}

	@Override
	public boolean isGameEnd() {
		return state instanceof Strike && state instanceof FirstRoll;
	}

	@Override
	public TotalScore addBeforeTotal(TotalScore beforeTotal) {
		return state.addNextFrameScore(beforeTotal);
	}

}
