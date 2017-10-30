package bowling.score;

import bowling.frame.Frame;

public class Score {

	public int calc(Frame frame, int count) {
		System.out.println(frame.getNo() + "번 프레임");
		int n = frame.getScore();
		if (count == 0) {
			n = frame.getScore();
			return n;
		}
		Frame next = frame.getNext();
		return n += calc(next, count - 1);
	}

}
