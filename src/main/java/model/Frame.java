package model;

import java.util.ArrayList;
import java.util.List;

import Exception.HasNotFinishedException;
import Exception.HasNotValueYetException;
import Exception.InvalidFrameNumberException;

public abstract class Frame {
	private int frameNum;
	private List<Pin> pins = new ArrayList<>();
	private Frame nextFrame;

	public Frame(int frameNum) {
		if (frameNum == 11) {
			throw new InvalidFrameNumberException();
		}
		this.frameNum = frameNum;
	
	}

	public int getFrameNum() {
		return frameNum;
	}

	public void addPins(Pin pin) {
		this.pins.add(pin);
	}

	public List<Pin> getPins() {
		return this.pins;
	}

	public Pin findPin(int index) {
		if (hasNoPins() || hasOnlyOnePin(index) || hasOnlyTwoPins(index)) {
			throw new HasNotValueYetException();
		}
		return this.pins.get(index);
	}
	
	private boolean hasNoPins() {
		return this.pins.isEmpty();
	}

	private boolean hasOnlyOnePin(int index) {
		return this.pins.size() == 1 && index == 1;
	}

	private boolean hasOnlyTwoPins(int index) {
		return this.pins.size() == 2 && index == 2;
	}
	public Frame addAfterDecide(Pin pin) throws InvalidFrameNumberException {
		this.addPins(pin);
		if (!this.isEnd()) {
			return this;
		}
		if (this.getFrameNum() >= 9) {
			this.nextFrame = new TenthFrame(this.getFrameNum() + 1);
			return this.nextFrame;
		}
		this.nextFrame = new NormalFrame(this.getFrameNum() + 1);
		return this.nextFrame;
	}
	
	public Score decide() throws HasNotFinishedException {
		if(!this.isEnd()) {// 끝나지 않은 프레임에 대한 처리.
			throw new HasNotFinishedException();
		}
		return decideCurrentScore();
	}
	
	public Score decideCurrentScore() {
		if(this.findPin(0).isStrike()){
			return new Score(10, 2);
		}
		if(this.findPin(0).isSpare(this.findPin(1))) {
			return new Score(10, 1);
		}
		return new Score(this.findPin(0).getPin() + this.findPin(1).getPin(), 0);
	}
	
	public Score calculateTenthScore(Score score) throws HasNotValueYetException {// 해당 프레임의 score를 계산하는 메소드.
		if (score.isEnd()) {
			return score;
		}
		if (score.getNextAddNo() == 2) {
			score.add(this.findPin(1).getPin());
		}
		score.add(this.findPin(2).getPin());
		return calculateTenthScore(score);
	}
	public Frame getNextFrame() throws HasNotFinishedException {
		if (!this.isEnd()) {
			throw new HasNotFinishedException();
		}
		return this.nextFrame;
	}

	public Status decideStatus() {
		// list to array
		return Status.createStatus(this.getPins().stream().map(s -> s).toArray(Pin[]::new));
	}

	public boolean isNewFrame(Frame frame) {
		return frame != this;
	}
	
	public boolean isTenthFrame() {
		if(this.frameNum == 10) {
			return true;
		}
		return false;
	}
	

	public abstract boolean isEnd();
	public abstract 	Score calculateScore(Score score) throws HasNotValueYetException;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frameNum;
		result = prime * result + ((pins == null) ? 0 : pins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (frameNum != other.frameNum)
			return false;
		if (pins == null) {
			if (other.pins != null)
				return false;
		} else if (!pins.equals(other.pins))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frame [frameNum=" + frameNum + ", pins=" + pins + "]";
	}

}
