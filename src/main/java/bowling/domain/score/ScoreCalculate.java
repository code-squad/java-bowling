package bowling.domain.score;

import java.util.function.Function;

import bowling.domain.frame.FrameElement;

import static bowling.utils.BowlingUtils.MAX_SCORE;
import static bowling.utils.BowlingUtils.MIN_SCORE;

public enum ScoreCalculate {
    STRIKE(frameElement -> frameElement.getFirstScore() == MAX_SCORE,
            frameElement -> ScoreType.STRIKE.get()),
    SPARE(frameElement -> frameElement.getFirstScore() + frameElement.getSecondScore() == MAX_SCORE,
            frameElement -> frameElement.getFirstScore() + "|" + "/"),
    MISS(frameElement -> frameElement.getFirstScore() > MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE,
            frameElement -> frameElement.getFirstScore() + "|" + "-"),
    GUTTER(frameElement -> frameElement.getFirstScore() == MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE,
            frameElement -> ScoreType.GUTTER.get()),
    NUMBER(frameElement -> {
                int totalScore = frameElement.getFirstScore() + frameElement.getSecondScore();
                return 1 <= totalScore && totalScore <= 9;
            },
            frameElement -> frameElement.getFirstScore() + "|" + frameElement.getSecondScore());

    private Function<FrameElement, Boolean> matchFunction;
    private Function<FrameElement, String> convertFunction;

    ScoreCalculate(Function<FrameElement, Boolean> matchFunction, Function<FrameElement, String> convertFunction) {
        this.matchFunction = matchFunction;
        this.convertFunction = convertFunction;
    }

    public boolean match(FrameElement frameElement) {
        return matchFunction.apply(frameElement);
    }

    public String convert(FrameElement frameElement) {
        return convertFunction.apply(frameElement);
    }
}