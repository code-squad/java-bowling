package model;

import Exception.HasNotNextFrameYetException;

public class NormalFrame extends Frame {
	public NormalFrame(int frameNum) {
		super(frameNum);
	}

	@Override
	public String whenIsMiss() {
		int score = this.findPin(0).getPin() + this.findPin(1).getPin();
		return score + "";
	}

	@Override
	public String whenIsSpare() {
		int score = 10;
		Frame firstNextFrame = super.getNextFrame();
		Pin firstFirstPin = firstNextFrame.findPin(0);
		if (firstFirstPin == null) {// 다음 투구가 값이 으면,
			return "";
		}
		score += firstFirstPin.getPin();
		return score + "";
	}

	@Override
	public String whenIsStrike() {// nextFrame 이 있는 상태.
		int score = 10;
		Frame firstNextFrame = super.getNextFrame();
		Pin firstFirstPin = firstNextFrame.findPin(0);
		if (firstFirstPin == null) {
			return "";
		}
		score += firstFirstPin.getPin();
		if (isTenthFrame(firstNextFrame)) {
			Pin secondPin = firstNextFrame.findPin(1);
			if (secondPin == null) {
				return "";
			}
			score += secondPin.getPin();
			return score + "";
		}
		// 다음 프레임 첫번째 투구까지 진행되었을때.
		if (firstFirstPin.isStrike()) {// 다음 프레임 첫번째 투구가 strike 일때.
			Frame secondNextFrame = returnSecondNextFrame(firstNextFrame);
			if (secondNextFrame == null) {
				return "";
			}
			// 다다음 프레임까지 진행되었을때.
			Pin secondFirstPin = secondNextFrame.findPin(0);
			if (secondFirstPin == null) {
				return "";
			}
			score += secondFirstPin.getPin();
			return score + "";
		}
		Pin firstSecondPin = firstNextFrame.findPin(1);
		if (firstSecondPin == null) {
			return "";
		}
		score += firstSecondPin.getPin();
		return score + "";
	}

	private boolean isTenthFrame(Frame nextFrame) {
		return nextFrame.getFrameNum() == 10;
	}

	public Frame returnSecondNextFrame(Frame firstNextFrame) {
		Frame secondNextFrame;
		try {
			secondNextFrame = firstNextFrame.getNextFrame();
		} catch (HasNotNextFrameYetException e) {// 아직 다다음 프레임 없는 경우.
			return null;
		}
		return secondNextFrame;
	}

	@Override
	public boolean isEnd() {
		if (this.getPins().isEmpty()) {
			return false;
		}
		if (this.getPins().size() >= 2 || this.findPin(0).isStrike()) {
			return true;
		}
		return false;
	}

}
