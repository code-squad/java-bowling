package bowling.model;

import java.util.List;

public interface Score {

	int currentScore();
	String toString();

	static Score of(List<Integer> scores) {
		if (scores == null)
			throw new IllegalArgumentException();

		int size = scores.size();

		if (size == 1 && scores.get(0) == 10)
			return new StrikeScore();

		if (size == 2 && scores.get(0) + scores.get(1) == 10)
			return new SpareScore(scores.get(0));

		if (size == 3)
			return new FinalScore(scores);

		return new MissScore(scores.get(0), scores.get(1));
	}
}