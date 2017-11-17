package model;

import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.InvalidPlayerNameException;

public class Player {
	
	private static final Logger logger = LoggerFactory.getLogger(Player.class);

	private String name;
	private SetOfFrame setOfFrame;

	public Player(String name, int numFrame) throws InvalidPlayerNameException {
		this.name = Optional.of(name).filter(e -> name.length() == 3 && Pattern.matches("^[a-zA-Z]*$", name))
				.orElseThrow(() -> new InvalidPlayerNameException("플레이어 이름이 잘 못 입력되었습니다."));
		setOfFrame = new SetOfFrame(numFrame);
	}
	
	public void shot(int score) {
		logger.debug(getName() + " : " + (setOfFrame.getCurrentFrameIndex() + 1) + "번째 프레임  " + score + "점  "
				+ "총점 : " + getTotalScore());
		setOfFrame.shot(score);
	}

	public String getName() {
		return name;
	}

	public boolean isEndCurrentFrame() {
		return setOfFrame.isNextFrame();
	}

	public int getTotalScore() {
		return setOfFrame.getTotalScore();
	}

	public String getCurrentScoreBoard() {
		return setOfFrame.getCurrentScoreBoard();
	}

	public String getEachCurrentFrameScore() {
		return setOfFrame.getCurrentFrameScoreBoard();
	}
}