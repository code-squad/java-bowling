package bowling.model;

import bowling.model.state.Ready;

public class NormalFrame extends AbstractFrame {
	private Frame nextFrame = null;
	private int frameNum;
	
	public NormalFrame(int frameNum) {
		super(new Ready(frameNum));
		this.frameNum = frameNum;
	}

	public Frame makeNextFrame() {
		if (frameNum == 9) {
			return nextFrame = new TenFrame();
		}
		return nextFrame = new NormalFrame(frameNum + 1);
	}

	public Frame play(int pin) {
		bowl(pin);
		if (isEnd()) {
			return makeNextFrame();
		} 
		return this;
	}
	
	public int getScore() {
		Score score = getStateScore();
		if(score.isFinish()){
			return score.getScore();
		}
		if(nextFrame != null) {
			return nextFrame.calculate(score);
		}
		return -1;
	}
	
	public int additionalCalculate(Score beforeScore) {
		if(nextFrame != null) {
			return nextFrame.calculate(beforeScore);
		}
		return -1;
	}
}