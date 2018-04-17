package frame;

import java.util.List;

import bowling.FrameInfo;
import bowling.TotalScore;
import state.Miss;
import state.Ready;
import state.Spare;
import state.State;
import state.Strike;

public class StrikeLastFrame implements Frame {

	private int frameNo;
	private Frame nextFrame;
	private State state;

	public StrikeLastFrame(int frameNo) {
		this.frameNo = frameNo;
		this.state = new Ready();
	}

	@Override
	public Frame roll(int pinsDown) {
		if (state.isFrameEnd()) {
			nextFrame = setNextFrame();
			return nextFrame.roll(pinsDown);
		}
		state = state.update(pinsDown);
		return this;
	}
	
	private Frame setNextFrame() {
		if (state instanceof Strike && frameNo == 1 && nextFrame == null) {
			return new StrikeLastFrame(2);
		}
		return nextFrame;
	}

	@Override
	public List<FrameInfo> getFrameInfo(List<FrameInfo> frameInfoList) {
		frameInfoList.add(state.setPinsDown(new FrameInfo(10)));
		return frameInfoList;
	}

	@Override
	public boolean isGameEnd() {
		if (nextFrame == null && state instanceof Strike) {
			return true;
		}

		if (state instanceof Miss || state instanceof Spare) {
			return true;
		}
		return false;
	}

	@Override
	public TotalScore addBeforeTotal(TotalScore beforeTotal) {
		TotalScore totalScore = state.addNextFrameScore(beforeTotal);
		
		if (totalScore != null && totalScore.canCalculateScore()) {
			return totalScore;
		}
		
		if (nextFrame == null) {
			return null;
		}
		return nextFrame.addBeforeTotal(totalScore);
	}

}
