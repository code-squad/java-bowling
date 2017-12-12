package bowling.model.state;

import bowling.model.Score;

public class Ready implements State {
	private int frameNum;
	
	public Ready(int frameNum) {
		this.frameNum = frameNum;
	}
	
	public Score getScore() {
		return new Score(-1, 0);
	}
	
	@Override
	public State play(int pin) {
		if(frameNum == 10) {
			return new TenFrameState(pin);
		}
		return new NormalState(pin);
	}

	@Override
	public String getStatus() {
		return "";
	}

	@Override
	public Score calculate(Score score) {
		return score;
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frameNum;
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
		Ready other = (Ready) obj;
		if (frameNum != other.frameNum)
			return false;
		return true;
	}

}
