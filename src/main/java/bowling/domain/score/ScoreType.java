package bowling.domain.score;

import bowling.domain.frame.element.Element;

import static bowling.utils.ScoreUtils.MAX_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_POSSIBLE_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.scoreResultFormat;

public enum ScoreType {
    STRIKE("X") {
        public boolean match(Element element) { return this.isStrike(element); }
        public String convert(Element element) { return this.get(); }
    },
    SPARE("/") {
        public boolean match(Element element) { return this.isSpare(element); }
        public String convert(Element element) { return scoreResultFormat(element.firstScoreToString(), this.get()); }
    },
    MISS("-") {
        public boolean match(Element element) { return this.isFirstMiss(element) || this.isSecondMiss(element); }
        public String convert(Element element) {
            if(this.isSecondMiss(element)) return scoreResultFormat(element.firstScoreToString(), this.get());
            return scoreResultFormat(this.get(), element.secondScoreToString());
        }
    },
    GUTTER("-"){
        public boolean match(Element element) { return this.isGutter(element); }
        public String convert(Element element) { return this.get(); }
    },
    NUMBER("") {
        public boolean match(Element element) { return this.isNumber(element); }
        public String convert(Element element) { return scoreResultFormat(element.firstScoreToString(), element.secondScoreToString()); }
    };

    private String value;

    ScoreType(String value) {
        this.value = value;
    }

    public abstract boolean match(Element element);

    public abstract String convert(Element element);

    public String get() {
        return value;
    }

    public boolean isStrike(Element element) {
        return element.getFirstScore() == MAX_SCORE;
    }

    boolean isSpare(Element element) {
        return element.hasSecondScore() && element.getFirstScore() + element.getSecondScore() == MAX_SCORE;
    }

    boolean isFirstMiss(Element element) {
        return element.hasSecondScore() && element.getFirstScore() == MIN_SCORE && element.getSecondScore() > MIN_SCORE && (element.getFirstScore() + element.getSecondScore()) != MAX_SCORE;
    }

    boolean isSecondMiss(Element element) {
        return element.hasSecondScore() && element.getFirstScore() > MIN_SCORE && element.getSecondScore() == MIN_SCORE && (element.getFirstScore() + element.getSecondScore()) != MAX_SCORE;
    }

    boolean isGutter(Element element) {
        return element.getFirstScore() == MIN_SCORE && (element.hasSecondScore() && element.getSecondScore() == MIN_SCORE);
    }

    boolean isNumber(Element element) {
        if(!element.hasSecondScore()) return false;
        int totalScore = element.getFirstScore() + element.getSecondScore();
        return MIN_POSSIBLE_SCORE <= totalScore && totalScore <= MAX_POSSIBLE_SCORE;
    }

}