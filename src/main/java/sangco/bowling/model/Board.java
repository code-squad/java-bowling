package sangco.bowling.model;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class Board {
	private HashMap<Integer, Frame> scoreBoard = new HashMap<>();
	private TotalScore totalScore = new TotalScore();
	
	
	public void createFrame(int frame, int scoreFirstRoll) {
		if(scoreBoard.size() == 9) {
			scoreBoard.put(frame, new LastFrame(scoreFirstRoll));
		}
		
		if(scoreFirstRoll == 10) {
			scoreBoard.put(frame, new StrikeFrame());
		}
		
		if(scoreFirstRoll < 10) {
			scoreBoard.put(frame, createOtherFrame(scoreFirstRoll));
		}
		scoreBoard.put(frame, totalScore.getFrameData(frame, scoreBoard.get(frame)));
	}
	
	Frame createOtherFrame(int scoreFirstRoll) {
		int scoreSecondRoll = InputView.getScore(scoreFirstRoll);
		
		if(scoreFirstRoll + scoreSecondRoll == 10) {
			return new SpareFrame(scoreFirstRoll, scoreSecondRoll);
		}
		
		return new NormalFrame(scoreFirstRoll, scoreSecondRoll);
	}
	
	public HashMap<Integer, Frame> getScoreBoard() {
		return scoreBoard;
	}
}
