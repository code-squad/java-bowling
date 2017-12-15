package sangco.bowling.model;

import java.util.HashMap;

import sangco.bowling.view.InputView;

public class Board {
	private HashMap<Integer, Frame> scoreBoard = new HashMap<>();
	
	
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
		
		// scoreBoard를 인자로 넘기면서 TotalScore 세팅하는 메소드 호출 
	}
	
	Frame createOtherFrame(int score) {
		int inputScore = InputView.getScore(score);
		
		if(score + inputScore == 10) {
			return new SpareFrame(score, inputScore);
		}
		
		return new NormalFrame(score, inputScore);
	}
	
	public HashMap<Integer, Frame> getScoreBoard() {
		return scoreBoard;
	}
}
