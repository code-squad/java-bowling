package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FramesOfPlayer {
	private static final Logger logger = LoggerFactory.getLogger(FramesOfPlayer.class);
	
	private SetOfFrame setOfFrame;
	private Player player;

	public FramesOfPlayer(String name, int numFrame) {
		setOfFrame = new SetOfFrame(numFrame);
		this.player = new Player(name);
	}

	public String getPlayerName() {
		return player.getName();
	}

	public void shot(int score) {
		logger.debug(getPlayerName() + " : " + (setOfFrame.getCurrentFrameIndex() + 1) + "번째 프레임  " + score + "점  "
				+ "총점 : " + getTotalScore());
		setOfFrame.shot(score);
	}

	public boolean isEndCurrentFrame() {
		return setOfFrame.isNextFrame();
	}

	public int getTotalScore() {
		return setOfFrame.getTotalScore();
	}

}
