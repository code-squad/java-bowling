package bowling.model;

public class Frame {

    int temp = -1;
	Score score;
	public Frame next;
	int id;

	public Frame() {
		this(1);
	}

	public Frame(int id) {
		this.id = id;
	}

	public Frame bowl(int intScore) {
	    if (temp < 0 && intScore == 10) {
	        score = new StrikeScore();
	        next = new Frame(id + 1);
	        return next;
        }

        if (temp < 0 && intScore < 10) {
	        temp = intScore;
	        return this;
        }

        if (temp + intScore == 10) {
	        score = new SpareScore(temp);
	        next = new Frame(id + 1);
	        return next;
        }

        if (temp + intScore < 10) {
	        score = new MissScore(temp, intScore);
	        next = new Frame(id + 1);
	        return next;
        }

        return this;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		if (score == null) {
			return temp == -1 ? "     " : "  " + temp + "  ";
		}
		return score.toString();
	}
}
