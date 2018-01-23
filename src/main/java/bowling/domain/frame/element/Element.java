package bowling.domain.frame.element;

import bowling.domain.score.Score;

import java.util.HashMap;
import java.util.Map;

import static bowling.domain.frame.Frame.FIRST_SCORE;
import static bowling.domain.frame.Frame.SECOND_SCORE;

public abstract class Element {
    Map<String, Score> scoreMap = new HashMap<>();

    abstract public boolean validTotalScore(Score nextScore);

    public Integer getFirstScore() {
        return scoreMap.get(FIRST_SCORE).get();
    }

    public String firstScoreToString() {
        return String.valueOf(getFirstScore());
    }

    public Integer getSecondScore() {
        return scoreMap.get(SECOND_SCORE).get();
    }

    public String secondScoreToString() {
        return String.valueOf(getSecondScore());
    }

    public boolean hasSecondScore() {
        return scoreMap.containsKey(SECOND_SCORE);
    }
}
