package bowling.model.score;

import java.util.List;
import java.util.stream.Collectors;

public interface Score {

	int currentScore();
	int firstScore();

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

	static String convertString(List<Integer> scores) {
//		if (scores.size() == 0)
//			return "   ";

		String str = scores.stream()
				.map(score -> score.toString())
				.collect(Collectors
						.joining("|"));

		str = str.replaceAll("10", "X");
		str = str.replaceAll("0", "-");

		StringBuilder builder = new StringBuilder(str);

		for (int i = 1; i < scores.size(); i++) {
			if (scores.get(i) > 0 && scores.get(i - 1) + scores.get(i) == 10) {
				builder.setCharAt(i * 2, '/');
			}
		}

		return builder.toString();
	}
}