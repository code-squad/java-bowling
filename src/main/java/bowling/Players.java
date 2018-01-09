package bowling;

import java.util.ArrayList;

public class Players {
	private ArrayList<Player> players = new ArrayList<>();
	private Player currentPlayer;
	private Frame currentFrame;
	private static int playerNum = 0;

	public Players(ArrayList<String> playerNames) {
		for (String name : playerNames) {
			players.add(new Player(name));
		}
		currentPlayer = players.get(0);
	}
	
	public Frame makeFirstFrame() {
		return new NormalFrame(0);
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
	
	
	
	public Integer validateAddScore(int score) throws Exception {
		try {
			currentFrame.isLeftPinExist(score);
		} catch (MyException e) {
			System.out.println(e.getErrorMessage());
			return null;
		}
		return score;

	}
	
	public void addScore(Integer score) throws Exception {
		currentPlayer.addScore(currentFrame, score);
		checkFrame();
		setNextFrame(currentFrame);
	}
	
	public void makeFrame(){
		if(currentPlayer.getFramesSize() == 0)
			currentFrame = makeFirstFrame();
	}

	public boolean isGameOver() {
		return players.get(players.size() - 1).isGameOver();
	}

	public boolean startGame() {
		return players.get(0).isGameStart();
	}

	public void checkFrame() {
		System.out.println(currentFrame.getFrame());
		currentFrame.countChance(currentFrame.setLastChance());
		if (!currentFrame.isNotEnd()){
			setNextPlayer();
			currentFrame =  currentPlayer.makeNextFrame();
		}
	}
	
	
	public void setNextPlayer() {
		currentPlayer = players.get(nextPlayerNum());
	}

	public ArrayList<String> calcStatusResult() {
		ArrayList<String> resultArray = new ArrayList<>();
		for (Player player : players) {
			resultArray.add(player.getStatusResult());
		}
		return resultArray;
	}

	public ArrayList<ArrayList<Integer>> calcTotalScore() {
		ArrayList<ArrayList<Integer>> totalArray = new ArrayList<>();
		for (Player player : players) {
			totalArray.add(player.getFrameScore());
		}
		return totalArray;
		
	}

	public void setNextFrame(Frame frame) {
		currentPlayer.setNextFrame(frame);
	}

	



	

}
