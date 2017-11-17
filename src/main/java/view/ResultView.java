package view;

import model.Game;

public class ResultView {
	public void currentResultView(Game game) {
		int numFrame = game.getNumFrame();
		System.out.println(frameMenuBar(numFrame));
		for (int i = 0; i < game.getNumPlayer(); i++) {
			System.out.println(playerBoard(i, game));
			System.out.println(scoreBoard(i, game));
		}
			
	}

	private String frameMenuBar(int numFrame) {
		String menuBar = "| NAME |";
		String frameNumber;
		for (int i = 0; i < numFrame; i++) {
			frameNumber = "  " + String.format("%02d", i + 1) + "  " + "|";
			menuBar += frameNumber;
		}
		return menuBar;
	}

	private String playerBoard(int index, Game game) {
		String playerName = game.getIndexPlayerName(index);
		String playerBoard = "|  " + playerName + " |" + game.getCurrentScoreBoard(index);
		return playerBoard;
	}
	
	private String scoreBoard(int index, Game game) {
		return "|      |" + game.getCurrentFrameScore(index);
		
	}
}
