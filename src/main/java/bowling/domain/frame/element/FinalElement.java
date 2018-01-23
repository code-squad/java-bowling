package bowling.domain.frame.element;

import bowling.domain.score.Score;

import static bowling.domain.frame.Frame.*;

public class FinalElement extends Element {

    public FinalElement(Score score) {
        scoreMap.put(FIRST_SCORE, score);
    }

    public static FinalElement generate(Score score) {
        return new FinalElement(score);
    }

    @Override
    public boolean validTotalScore(Score nextScore) {
        return scoreMap.get(FIRST_SCORE).validTotalScore(nextScore);
    }

    public FinalElement inScore(Score nextScore) {
        scoreMap.put(SECOND_SCORE, nextScore);
        return this;
    }

    public boolean hasThirdScore() { return scoreMap.containsKey(THIRD_SCORE); }
}
