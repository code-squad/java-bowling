package bowling.domain.score;

import static bowling.domain.frame.Frame.*;

public class FinalScore extends EntireScore {

    public FinalScore(Score score) {
        scoreMap.put(FIRST_SCORE, score);
    }

    public static FinalScore generate(Score score) {
        return new FinalScore(score);
    }

    @Override
    public boolean validTotalScore(Score nextScore) {
        return scoreMap.get(FIRST_SCORE).validTotalScore(nextScore);
    }

    public FinalScore inScore(String key, Score nextScore) {
        scoreMap.put(key, nextScore);
        return this;
    }

    public boolean hasThirdScore() { return scoreMap.containsKey(THIRD_SCORE); }

    public Score getScoreByKey(String key) { return scoreMap.get(key); }
}
