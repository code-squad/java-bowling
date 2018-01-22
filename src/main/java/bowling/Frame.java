package bowling;

public class Frame {

    int temp = -1;
	Score score;
	Frame next;

	public Frame bowl(int intScore) {
	    if (temp < 0 && intScore == 10) {
	        score = new StrikeScore();
	        next = new Frame();
	        return next;
        }

        if (temp < 0 && intScore < 10) {
	        temp = intScore;
	        return this;
        }

        if (temp + intScore == 10) {
	        score = new SpareScore(temp);
	        next = new Frame();
	        return next;
        }

        if (temp + intScore < 10) {
	        score = new MissScore(temp, intScore);
	        next = new Frame();
	        return next;
        }

        return this;
	}

}
