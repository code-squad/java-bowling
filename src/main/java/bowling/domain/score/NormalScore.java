package bowling.domain.score;

import static bowling.domain.frame.Frame.FIRST_SCORE;
import static bowling.domain.frame.Frame.SECOND_SCORE;

public class NormalScore extends EntireScore {

    public NormalScore(Score score) {
        scoreMap.put(FIRST_SCORE, score);
    }

    public static NormalScore generate(Score score) {
        return new NormalScore(score);
    }

    @Override
    public boolean validTotalScore(Score nextScore) {
        return scoreMap.get(FIRST_SCORE).validTotalScore(nextScore);
    }

    public NormalScore inScore(Score secondScore) {
        scoreMap.put(SECOND_SCORE, secondScore);
        return this;
    }
}
