package model;

public class Frame {
	private Score score;
	private int frameNum;
	// 몇번째 프레임인지.
	
	public void updateFrameNum(int newFrameNum) {
		this.frameNum = newFrameNum;
	}
	public void updateScore(Score newScore) {
		this.score = newScore;
	}
	public Frame createFrameOrNot() {
		// 조건에 따라 새 프레임 or 기존 프레임 반환.
		if(stillHasSpaceIn() == true) {
			return this;
		}
		return new Frame();
	}
	public boolean stillHasSpaceIn() {
		if(this.score.getResult().length() == 1 && this.score.getResult() !="X") {
			return true;
		}
		return false;
	}
	
	public Score getScore() {
		return this.score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}
	
	
	
}
