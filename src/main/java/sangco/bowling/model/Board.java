package sangco.bowling.model;

import java.util.HashMap;

import sangco.bowling.model.frame.Frame;
import sangco.bowling.model.frame.LastFrame;
import sangco.bowling.model.frame.NormalFrame;
import sangco.bowling.model.frame.SpareFrame;
import sangco.bowling.model.frame.StrikeFrame;
import sangco.bowling.view.InputView;

public class Board {
	private HashMap<Integer, Frame> scoreBoard = new HashMap<>();

	public void createFrame(int frame, int scoreFirstRoll) {
		if (frame == 10) {
			scoreBoard.put(frame, new LastFrame(scoreFirstRoll));
		}

		if (scoreFirstRoll == 10) {
			scoreBoard.put(frame, new StrikeFrame());
		}

		if (scoreFirstRoll < 10) {
			scoreBoard.put(frame, createOtherFrame(scoreFirstRoll));
		}
		scoreBoard = setFrameData(frame);
	}

	Frame createOtherFrame(int scoreFirstRoll) {
		int scoreSecondRoll = InputView.getScore(scoreFirstRoll);

		if (scoreFirstRoll + scoreSecondRoll == 10) {
			return new SpareFrame(scoreFirstRoll, scoreSecondRoll);
		}

		return new NormalFrame(scoreFirstRoll, scoreSecondRoll);
	}

	public HashMap<Integer, Frame> getScoreBoard() {
		return scoreBoard;
	}

	private HashMap<Integer, Frame> setFrameData(int frame) {
		if (frame <= 3) {
			return setEarlyFrameTotal(frame);
		}
		if (frame == 10) {
			return setLastFrameTotal(frame);
		}
		return setFrameTotal(frame);
	}

	public HashMap<Integer, Frame> setEarlyFrameTotal(int frame) {
		if(frame == 1) {
			if (scoreBoard.get(frame) instanceof StrikeFrame) {
				
			}
		}
		if(frame == 2) {
			if (scoreBoard.get(frame-1) instanceof SpareFrame) {
				
			}
			if (scoreBoard.get(frame) instanceof NormalFrame) {
				
			}
		}
		if(frame == 3) {
			if (scoreBoard.get(frame-2) instanceof StrikeFrame) {
				
			}
			if (scoreBoard.get(frame-1) instanceof SpareFrame) {
				
			}
			if ((scoreBoard.get(frame-1) instanceof StrikeFrame) && !(scoreBoard.get(frame) instanceof StrikeFrame)) {
				
			}
			if (scoreBoard.get(frame) instanceof NormalFrame) {
				
			}
		}
		return scoreBoard;
	}
	
	public HashMap<Integer, Frame> setLastFrameTotal(int frame) {
		return scoreBoard;
	}
	
	public HashMap<Integer, Frame> setFrameTotal(int frame) {
		Frame thisFrame = scoreBoard.get(frame);
		Frame preFrame = scoreBoard.get(frame - 1);
		Frame prePreFrmae = scoreBoard.get(frame - 2);

		if ((prePreFrmae instanceof StrikeFrame) && (preFrame instanceof StrikeFrame)) {
			return TotalScore.setPrePreFrame(frame, scoreBoard);
			// 앞에 앞에 토탈값 설정
		}

		if ((preFrame instanceof StrikeFrame) && !(thisFrame instanceof StrikeFrame)) {
			return TotalScore.setPreFrame(frame, scoreBoard);
			// 앞에 프레임 토탈값 설정
		}
		if (preFrame instanceof SpareFrame) {
			
			// 앞에 프레임 토탈값 설정
		}
		if (thisFrame instanceof NormalFrame) {
			
			// 앞에 프레임 토탈값 설정
		}
		return scoreBoard;
	}
}
