package model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.InvalidGameSetException;

public class Game {
	
	private static final Logger logger = LoggerFactory.getLogger(Game.class);

	private boolean endSetGame = false;
	private List<FramesOfPlayer> players;
	private int numFrame;
	private int numPlayer;
	private int currentPlayerNum = 0;
	
	public Game(int numFrame) {
		this.numFrame = numFrame;
		players = new ArrayList<FramesOfPlayer>();
	}

	public String getIndexPlayerName(int index) {
		return players.get(index).getPlayerName();
	}

	public int getNumFrame() {
		return numFrame;
	}

	public String getCurrentPlayerName() {
		return players.get(currentPlayerNum).getPlayerName();
	}

	public void addPlayer(String name) throws InvalidGameSetException {
		if (endSetGame)
			throw new InvalidGameSetException("게임 설정이 완료되어 플레이어를 추가 할 수 없습니다.");
		players.add(new FramesOfPlayer(name, numFrame));
	}

	public void gameStart() {
		endSetGame = true;
		numPlayer = players.size();
	}

	private void nextPlayer() {
		int checkPlayer = currentPlayerNum + 1;
		if (currentPlayerNum > numPlayer - 2)
			checkPlayer = 0;
		currentPlayerNum = checkPlayer;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	private FramesOfPlayer currentPlayer() {
		return players.get(currentPlayerNum);
	}

	public void shot(int score) {
		if (currentPlayer().isEndCurrentFrame()) {
			logger.debug("nextPlayer : " + currentPlayerNum);
			nextPlayer();
		}
		currentPlayer().shot(score);
	}

	public int getTotalScore(int index) {
		return players.get(index).getTotalScore();
	}

	public String getCurrentScoreBoard(int index) {
		return players.get(index).getCurrentScoreBoard() + "|";
	}

	public String getCurrentFrameScore(int index) {
		return players.get(index).getEachCurrentFrameScore();
	}
}