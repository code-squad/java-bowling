package frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.FrameInfo;
import bowling.TotalScore;
import state.Ready;
import state.State;

public class NormalFrame implements Frame {

	private static final Logger log = LoggerFactory.getLogger(NormalFrame.class);

	private int frameNo;
	private Frame nextFrame;
	private State state;

	public NormalFrame() {
		this(1);
	}

	public NormalFrame(int frameNo) {
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
		if (nextFrame == null && frameNo == 10) {
			return new LastFrame();
		}

		if (nextFrame == null) {
			return new NormalFrame(frameNo + 1);
		}
		return nextFrame;
	}
	
	@Override
	public FrameInfo getFrameInfo() {
		if (state.isFrameEnd()) {
			return state.setPinsDown(new FrameInfo(frameNo, nextFrame, state, getTotalScore()));
		}
		return state.setPinsDown(new FrameInfo(frameNo, nextFrame, state));
	}
	
	@Override
	public boolean isGameEnd() {
		return frameNo == 10 && state.isFrameEnd();
	}

	private TotalScore getTotalScore() {
		TotalScore totalScore = state.getTotalScore();

		if (!totalScore.canCalculateScore() && nextFrame != null) {
			return nextFrame.addBeforeTotal(totalScore);
		}
		return totalScore;
	}

	public TotalScore addBeforeTotal(TotalScore beforeTotal) {
		TotalScore totalScore = state.addNextFrameScore(beforeTotal);

		if (totalScore == null) {
			return null;
		}
		if (totalScore.canCalculateScore()) {
			return totalScore;
		}
		return nextFrame.addBeforeTotal(totalScore);
	}

}
