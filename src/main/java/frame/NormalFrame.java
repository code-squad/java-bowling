package frame;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.FrameInfo;
import bowling.TotalScore;
import state.Miss;
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
		if (nextFrame == null && isLastFrame() && state.generateLastFrame() == null) {
			return state.generateLastFrame();
		}

		if (nextFrame == null) {
			return new NormalFrame(frameNo + 1);
		}
		return nextFrame;
	}

	@Override
	public List<FrameInfo> getFrameInfo(List<FrameInfo> frameInfoList) {
		if (state.isFrameEnd() && nextFrame != null) {
			frameInfoList.add(state.setPinsDown(new FrameInfo(frameNo, getTotalScore())));
			return nextFrame.getFrameInfo(frameInfoList);
		}
		if (state instanceof Miss && nextFrame == null) {
			frameInfoList.add(state.setPinsDown(new FrameInfo(frameNo, getTotalScore())));
			return frameInfoList;
		}
		frameInfoList.add(state.setPinsDown(new FrameInfo(frameNo)));
		return frameInfoList;
	}

	@Override
	public boolean isGameEnd() {
		return isLastFrame() && needExtraFrame();
	}

	boolean isLastFrame() {
		return frameNo == 10 && state.isFrameEnd();
	}

	boolean needExtraFrame() {
		return state.getTotalScore().canCalculateScore();
	}

	private TotalScore getTotalScore() {
		TotalScore totalScore = state.getTotalScore();

		if (!totalScore.canCalculateScore() && nextFrame != null) {
			return nextFrame.addBeforeTotal(totalScore);
		}
		return totalScore;
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
