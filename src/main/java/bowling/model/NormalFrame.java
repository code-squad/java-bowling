package bowling.model;

import bowling.model.state.Ready;
import bowling.model.state.State;

public class NormalFrame extends Frame {
	private State state;
	private Frame nextFrame = null;
	private int frameNum;
	
	public NormalFrame(int frameNum) {
		this.frameNum = frameNum;
		this.state = new Ready(frameNum);
	}

	public Frame makeNextFrame() {
		if (frameNum == 9) {
			return nextFrame = new TenFrame();
		}
		return nextFrame = new NormalFrame(frameNum + 1);
	}

	public Frame play(int pin) {
		state = state.play(pin);
		if (state.isEnd()) {
			return makeNextFrame();
		} 
		return this;
	}
	
	public String getStatus() {
		return state.getStatus();
	}

	public boolean isEnd() {
		return state.isEnd();
	}

	public int getScore() {
		Score score = state.getScore();
		if(score.isFinish()){
			return score.getScore();
		}
		if(nextFrame != null) {
			return nextFrame.calculate(score);
		}
		return -1;
	}
	
	public int calculate(Score beforeScore) {
		Score score = state.calculate(beforeScore);
		if(score.isFinish()) {
			return score.getScore();
		}
		if(nextFrame != null) {
			return nextFrame.calculate(score);
		}
		return -1;
	}
}