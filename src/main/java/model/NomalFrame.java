package model;

import Exception.FrameScoreException;

public class NomalFrame extends Frame {

	public NomalFrame() {
		super();
	}


	public void shot(int score) throws FrameScoreException {
		frameScore.shot(score);
	}
}
