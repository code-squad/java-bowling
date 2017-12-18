package sangco.bowling.model;

import java.util.HashMap;

import sangco.bowling.model.frame.Frame;

public class TotalScore {

	
	
	
	
	
	
	
	public static HashMap<Integer, Frame> setPrePreFrame(int frame, HashMap<Integer, Frame> scoreBoard) {
		scoreBoard.get(frame-2).setGameTotalScore(scoreBoard.get(frame-3).getGameTotalScore() + 10 + scoreBoard.get(frame).getFirstRoll());
		return scoreBoard;
	}

	public static HashMap<Integer, Frame> setPreFrame(int frame, HashMap<Integer, Frame> scoreBoard) {
		scoreBoard.get(frame-1).setGameTotalScore(scoreBoard.get(frame-2).getGameTotalScore() + scoreBoard.get(frame).getFrameTotalScore());
		return scoreBoard;
	}
}
