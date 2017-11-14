package bowling.score;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Score {

	private static final Logger log = LoggerFactory.getLogger(Score.class);

	private int score;
	private Score next;

	public Score inputScore(int score) {
		this.score = score;
		next = nextScore();
		return next;
	}

	private Score nextScore() {
		return new Score();
	}

	public int totalScore(int count) {
		int temp = 0;
		Score score = this;
		for (int i = 0; i < count; i++) {
			temp += score.score;
			score = getNext();
		}
		return temp;
	}

	private Score getNext() {
		return next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + score;
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
		Score other = (Score) obj;
		if (score != other.score)
			return false;
		return true;
	}

}
