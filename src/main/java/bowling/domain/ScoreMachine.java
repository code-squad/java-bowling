package bowling.domain;

import java.util.Arrays;
import java.util.Optional;

import bowling.domain.frame.FrameElement;
import bowling.domain.score.ScoreType;

import static bowling.domain.score.ScoreType.MISS;
import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;

public class ScoreMachine {

    public static String calculateScore(FrameElement frameElement) {
        Optional<ScoreType> scoreCalculate = Arrays.stream(ScoreType.values()).filter(type -> type.match(frameElement)).findFirst();
        return scoreCalculate.map(scoreCalculate1 -> scoreCalculate1.convert(frameElement)).get();
    }

    public static String firstCalculate(FrameElement frameElement) {
        if(STRIKE.match(frameElement)) { return STRIKE.convert(frameElement); }
        else if(isValidNumber(frameElement.getFirstScore())) { return frameElement.firstScoreToString(); }
        return MISS.get();
    }

    private static boolean isValidNumber(Integer score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }
}
