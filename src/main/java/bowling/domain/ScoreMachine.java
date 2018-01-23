package bowling.domain;

import bowling.domain.frame.element.Element;
import bowling.domain.score.ScoreType;

import java.util.Arrays;
import java.util.Optional;

import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;

public class ScoreMachine {

    public static String calculateScore(Element element) {
        Optional<ScoreType> scoreCalculate = Arrays.stream(ScoreType.values()).filter(type -> type.match(element)).findFirst();
        return scoreCalculate.map(scoreCalculate1 -> scoreCalculate1.convert(element)).get();
    }

    public static String firstCalculate(Element element) {
        if(STRIKE.match(element)) { return STRIKE.convert(element); }
        else if(isValidNumber(element.getFirstScore())) { return element.firstScoreToString(); }
        return MISS.get();
    }

    private static boolean isValidNumber(Integer score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }
}
