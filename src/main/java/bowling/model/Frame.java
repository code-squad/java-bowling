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
        if (temp < 0 && intScore < 10) {
	        temp = intScore;
	        return this;
        }

	    if (temp < 0 && intScore == 10) {
	        score = new StrikeScore();
        }

        if (temp >= 0 && temp + intScore == 10) {
	        score = new SpareScore(temp);
        }

        if (temp >= 0 && temp + intScore < 10) {
	        score = new MissScore(temp, intScore);
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

	@Override
	public String toString() {
		if (score == null) {
			return temp == -1 ? "     " : "  " + ((temp == 0) ? "-" : temp) + "  ";
		}
		return score.toString();
	}
}
