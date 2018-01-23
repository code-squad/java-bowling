package bowling.model;

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

	@Override
	public String toString() {
		if (score == null) {
			return temp.size() == 0 ? "     " : "  " + (temp.get(0) == 0 ? "-" : temp.get(0)) + "  ";
		}
		return score.toString();
	}
}
