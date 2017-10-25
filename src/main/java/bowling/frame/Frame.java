package bowling.frame;

import bowling.frame.state.Ready;
import bowling.frame.state.Score;
import bowling.frame.state.State;

public class Frame {
    public static final int UN_SCORE_STATE = -1;
    
	private Frame next;
	private State state;
	private int no;

	public Frame(int no) {
		this.state = new Ready();
		this.no = no;
	}

	public Frame bowl(int countOfPin) {
		state = state.bowl(countOfPin);
		if (state.isFinish()) {
			next = new Frame(no + 1);
			return next;
		}
		return this;
	}

	public int getNo() {
		return no;
	}
	
	private int getScore() {
	    Score score = state.getScore();
	    if (score.canCalucateScore()) {
	        return score.getScore();
	    }
	    
	    return next.cacluateAdditionalScore(score);
	}
	
	private int cacluateAdditionalScore(Score beforeScore) {
	    Score score = state.cacluateAdditionalScore(beforeScore);
	    if (score.canCalucateScore()) {
            return score.getScore();
        }
	    return next.cacluateAdditionalScore(score);
	}

	FrameResult getFrameResult() {
		if (!state.isFinish()) {
			return new FrameResult(state.getDesc(), UN_SCORE_STATE);
		}
		
		try {
		    return new FrameResult(state.getDesc(), getScore());
		} catch (CannotCalculateException e) {
		    return new FrameResult(state.getDesc(), UN_SCORE_STATE);
		}
	}
	
	private void addFrameResult(Board board) {
	    board.add(getFrameResult());
	    
	    if (next != null) {
	        next.addFrameResult(board);
	    }
	}
	
	public Board createBoard() {
	    Board board = new Board();
	    addFrameResult(board);
	    return board;
	}
}
