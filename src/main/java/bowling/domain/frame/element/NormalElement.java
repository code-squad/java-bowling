package bowling.domain.frame.element;

import bowling.domain.score.Score;

import static bowling.domain.frame.Frame.FIRST_SCORE;
import static bowling.domain.frame.Frame.SECOND_SCORE;

public class NormalElement extends Element {

    public NormalElement(Score score) {
        scoreMap.put(FIRST_SCORE, score);
    }

    public static NormalElement generate(Score score) {
        return new NormalElement(score);
    }

    @Override
    public boolean validTotalScore(Score nextScore) {
        return scoreMap.get(FIRST_SCORE).validTotalScore(nextScore);
    }

    public NormalElement inScore(Score secondScore) {
        scoreMap.put(SECOND_SCORE, secondScore);
        return this;
    }
}
