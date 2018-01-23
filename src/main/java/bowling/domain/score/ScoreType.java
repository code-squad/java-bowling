package bowling.domain.score;

import bowling.domain.frame.FrameElement;

import static bowling.utils.ScoreUtils.MAX_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.emptyBlockFormat;
import static bowling.utils.StringUtils.scoreResultFormat;
import static bowling.utils.StringUtils.getIngFormat;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(FrameElement frameElement) { return this.isStrike(frameElement); }
        public String convert(FrameElement frameElement) { return emptyBlockFormat(this.get()); }
    },
    SPARE("/") {
        public boolean match(FrameElement frameElement) { return this.isSpare(frameElement); }
        public String convert(FrameElement frameElement) { return getIngFormat(scoreResultFormat(frameElement.firstScoreToString(), this.get())); }
    },
    MISS("-") {
        public boolean match(FrameElement frameElement) { return this.isFirstMiss(frameElement) || this.isSecondMiss(frameElement); }
        public String convert(FrameElement frameElement) {
            if(this.isSecondMiss(frameElement)) return getIngFormat(scoreResultFormat(frameElement.firstScoreToString(), this.get()));
            return getIngFormat(scoreResultFormat(this.get(), frameElement.secondScoreToString()));
        }
    },
    GUTTER("-"){
        public boolean match(FrameElement frameElement) { return this.isGutter(frameElement); }
        public String convert(FrameElement frameElement) { return emptyBlockFormat(this.get()); }
    },
    NUMBER("") {
        public boolean match(FrameElement frameElement) { return this.isNumber(frameElement); }
        public String convert(FrameElement frameElement) { return getIngFormat(scoreResultFormat(frameElement.firstScoreToString(), frameElement.secondScoreToString())); }
    };

    private String value;

    ScoreType(String value) {
        this.value = value;
    }

    public abstract boolean match(FrameElement frameElement);

    public abstract String convert(FrameElement frameElement);

    public String get() {
        return value;
    }

    public boolean isStrike(FrameElement frameElement) {
        return frameElement.getFirstScore() == MAX_SCORE;
    }

    boolean isSpare(FrameElement frameElement) {
        return frameElement.getFirstScore() + frameElement.getSecondScore() == MAX_SCORE;
    }

    boolean isFirstMiss(FrameElement frameElement) {
        return frameElement.getFirstScore() == MIN_SCORE && frameElement.getSecondScore() > MIN_SCORE;
    }

    boolean isSecondMiss(FrameElement frameElement) {
        return frameElement.getFirstScore() > MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE;
    }

    boolean isGutter(FrameElement frameElement) {
        return frameElement.getFirstScore() == MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE;
    }

    boolean isNumber(FrameElement frameElement) {
        int totalScore = frameElement.getFirstScore() + frameElement.getSecondScore();
        return MIN_POSSIBLE_SCORE <= totalScore && totalScore <= MAX_POSSIBLE_SCORE;
    }
}