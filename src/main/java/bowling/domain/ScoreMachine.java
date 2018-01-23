package bowling.domain;

import java.util.Arrays;
import java.util.Optional;

import bowling.domain.frame.FrameElement;
import bowling.domain.score.ScoreCalculate;

import static bowling.domain.score.ScoreCalculate.STRIKE;

public class ScoreMachine {

    public static String calculateScore(FrameElement frameElement) {
        Optional<ScoreCalculate> scoreCalculate = Arrays.stream(ScoreCalculate.values()).filter(type -> type.match(frameElement)).findFirst();
        return scoreCalculate.map(scoreCalculate1 -> scoreCalculate1.convert(frameElement)).get();
    }

    public static String calculateStrike(FrameElement frameElement) {
        if(STRIKE.match(frameElement)) {
            return STRIKE.convert(frameElement);
        }
        return null;
    }
}
