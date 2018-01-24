package bowling.domain;

import bowling.domain.frame.element.Element;
import bowling.domain.frame.element.NormalElement;
import bowling.domain.score.ScoreType;
import bowling.utils.StringUtils;

import java.util.Arrays;
import java.util.Optional;

import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;

public class ScoreMachine {

    public static Optional<ScoreType> calculateScore(Element element) {
        Optional<ScoreType> scoreCalculate = Arrays.stream(ScoreType.values()).filter(type -> type.match(element)).findFirst();
        return scoreCalculate;
    }

    public static String convertScoreToString(ScoreType scoreType, Element element) {
        return scoreType.convert(element);
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
