package bowling.model.frame;

import bowling.model.score.Score;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private int id;
	protected List<Integer> temp;
	protected Score score;
	private Frame next;

	public Frame() {
		this(1);
	}

	public Frame(int id) {
		this.id = id;
		this.temp = new ArrayList<>();
	}

	public Frame bowl(int intScore) {
		temp.add(intScore);
	    score = Score.of(temp);

		if (temp.size() < 2 && intScore < 10) {
			return this;
		}

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

	public int getScore() throws Exception {
		if (score == null) {
			throw new IllegalStateException();
		}
		try {
			return score.getScore(getNextScore(), next.getNextScore());
		} catch (NullPointerException e) {
			return score.getScore(getNextScore(), null);
		}
	}

	protected Score getNextScore() throws Exception {
		return this.next.score;
	}

	@Override
	public String toString() {
		if (temp.isEmpty()) {
			return "     ";
		}
		return Score.convertString(temp);
	}
}
