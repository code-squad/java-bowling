package bowling.score;

import bowling.frame.Frame;

public class Score {

	public int calc(Frame frame, int count) {
		if (frame == null) {
			try {
				throw new NullPointerException();
			} catch (NullPointerException e) {
				// e.printStackTrace();
			}
			return 0;
		}
		int n = frame.getScore();
		if (count == 0) {
			return frame.getScore();
		}
		Frame next = frame.getNext();
		return n += calc(next, count - 1);
	}

}
