package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.ScoreMachine;
import bowling.domain.frame.element.NormalElement;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.calculateScore;
import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.score.ScoreType.STRIKE;

public class NormalFrame implements Frame {
    private NormalElement normalElement;
    private String result;

    private NormalFrame(Score score) {
        normalElement = normalElement.generate(score);
        result = ScoreMachine.firstCalculate(normalElement);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return STRIKE.match(normalElement) || normalElement.hasSecondScore();
    }

    @Override
    public NormalFrame nextRound(Score secondScore) {
        if(!normalElement.validTotalScore(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }

        Optional<ScoreType> scoreType = calculateScore(normalElement.inScore(secondScore));
        result = scoreType.map(type -> convertScoreToString(type, normalElement)).get();

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public NormalElement getElement() {
        return normalElement;
    }
}
