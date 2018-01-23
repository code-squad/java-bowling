package bowling.model.frame;

import bowling.model.score.MissScore;
import bowling.model.score.Score;
import bowling.model.score.SpareScore;
import bowling.model.score.StrikeScore;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private int id;
	protected List<Integer> temp;
	protected Score score;
	public Frame next;

	public Frame() {
		this(1);
	}

	public Frame(int id) {
		this.id = id;
		this.temp = new ArrayList<>();
	}

	public Frame bowl(int intScore) {
		temp.add(intScore);

		if (temp.size() < 2 && intScore < 10) {
	        return this;
        }

	    score = Score.of(temp);

        if (id == 9) {
        	next = new FinalFrame();
	        return next;
        }

        next = new Frame(id + 1);
		return next;
	}

	public int getId() {
		return id;
	}

	public boolean isStrike() {
		if (temp.isEmpty())
			throw new IllegalStateException();
		return score instanceof StrikeScore;
	}

	public int getScore() throws Exception {
		if (score instanceof MissScore)
			return this.getFramePinCount();
		if (score instanceof SpareScore)
			return this.getFramePinCount() + next.getFirstPinCount();
		if (score instanceof StrikeScore) {
			if (next.isStrike() && next.next.isStrike()) {
				return 30;
			} else {
				return this.getFramePinCount() + next.getFramePinCount();
			}
		}

		throw new IllegalStateException();
	}

	private int getFramePinCount() {
		if(score != null)
			return score.currentScore();

		throw new IllegalStateException();
	}

	private int getFirstPinCount() {
		if(score != null)
			return score.firstScore();

		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		if (temp.isEmpty()) {
			return "     ";
		}
		return Score.convertString(temp);
	}
}
