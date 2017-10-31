package bowling.frame;

import bowling.score.Score;
import bowling.state.End;
import bowling.state.LastRunning;
import bowling.state.Ready;
import bowling.state.Spare;
import bowling.state.State;
import bowling.state.Strike;

public abstract class Frame {
	private int no;
	private State state;
	private Frame next;
	private int continueScore;

	public Frame(int no) {
		this.no = no;
		state = new Ready();
	}

	public Frame(int no, LastRunning lastRunning) {
		this.no = no;
		state = lastRunning;
	}

	public int getNo() {
		return no;
	}

	public Frame bowl(int score) {
		this.state = state.bowl(score);
		if (state instanceof End) {
			no += 1;
			if (no < 10) {
				return next = new NomalFrame(no);
			}
			return next = new LastFrame(no);
		}
		return this;
	}

	public Frame getNext() {
		return next;
	}

	public int getScore() {
		return state.getScore();
	}

	public int getFirstScore() {
		return state.getFirstBowlScore();
	}

	public int getSecondScore() {
		return state.getSecondBowlScore();
	}

	public State getState() {
		return state;
	}

	public Frame getFrame() {
		return this;
	}

	public String getChar() {
		return state.getChar();
	}

	// public List<FrameResult> createFrameResults() {
	// List<FrameResult> result = new ArrayList<>();
	// return result.add(FrameResult.add(calc()));
	// }

	public int calc() {
		Score scores = new Score();
		if (state instanceof Strike) {
			return scores.calc(continueScore, this, 2);
		}
		if (state instanceof Spare) {
			return scores.calc(continueScore, this, 1);
		}
		return scores.calc(continueScore, this, 0);
	}

	public static Frame create(int no) {
		if (no < 10) {
			return new NomalFrame(no);
		}
		return new LastFrame(no);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (no != other.no)
			return false;
		return true;
	}

}
