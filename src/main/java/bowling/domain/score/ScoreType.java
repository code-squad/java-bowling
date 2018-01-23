package bowling.domain.score;

import bowling.domain.frame.FrameElement;

import static bowling.utils.BowlingUtils.MAX_POSSIBLE_SCORE;
import static bowling.utils.BowlingUtils.MAX_SCORE;
import static bowling.utils.BowlingUtils.MIN_POSSIBLE_SCORE;
import static bowling.utils.BowlingUtils.MIN_SCORE;
import static bowling.utils.BowlingUtils.formatScoreResult;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(FrameElement frameElement) { return frameElement.getFirstScore() == MAX_SCORE; }
        public String convert(FrameElement frameElement) { return this.get(); }
    },
    SPARE("/") {
        public boolean match(FrameElement frameElement) { return frameElement.getFirstScore() + frameElement.getSecondScore() == MAX_SCORE; }
        public String convert(FrameElement frameElement) { return formatScoreResult(frameElement.firstScoreToString(), this.get()); }
    },
    MISS("-") {
        public boolean match(FrameElement frameElement) { return frameElement.getFirstScore() > MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE; }
        public String convert(FrameElement frameElement) { return formatScoreResult(frameElement.firstScoreToString(), this.get()); }
    },
    GUTTER("-"){
        public boolean match(FrameElement frameElement) { return frameElement.getFirstScore() == MIN_SCORE && frameElement.getSecondScore() == MIN_SCORE; }
        public String convert(FrameElement frameElement) { return this.get(); }
    },
    NUMBER("") {
        public boolean match(FrameElement frameElement) {
            int totalScore = frameElement.getFirstScore() + frameElement.getSecondScore();
            return MIN_POSSIBLE_SCORE <= totalScore && totalScore <= MAX_POSSIBLE_SCORE;
        }
        public String convert(FrameElement frameElement) { return formatScoreResult(frameElement.firstScoreToString(), frameElement.secondScoreToString()); }
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
}