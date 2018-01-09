package bowling;

import java.util.ArrayList;

public class Players {
	private ArrayList<Player> players = new ArrayList<>();
	private Player currentPlayer;
	private static int playerNum = 0;

	public Players(ArrayList<String> playerNames) {
		for (String name : playerNames) {
			players.add(new Player(name));
		}
		currentPlayer = players.get(0);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public int nextPlayerNum() {
		if (playerNum == players.size() - 1) {
			playerNum = 0;
			return playerNum;
		}
		playerNum += 1;
		return playerNum;
	}

	public boolean isGameOver() {
		return players.get(players.size() - 1).isGameOver();
	}

	public boolean startGame() {
		return players.get(0).isGameStart();
	}

	public Frame checkFrame(Frame currentFrame) {
		if (currentFrame.isMakeOkay()){
			setNextPlayer();
			return makeNextFrame(currentPlayer.getFramesSize());
		}
		return currentFrame;
	}
	
	private Frame makeNextFrame(int framesSize) {
		if (framesSize < 9) {
			return new NormalFrame(framesSize);
		}
		if (framesSize == 9) {
			return  new FinalFrame(framesSize);
		}
		return null;
	}

	public void setNextPlayer() {
		currentPlayer = players.get(nextPlayerNum());
	}

}
