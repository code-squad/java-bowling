package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.ScoreMachine;
import bowling.domain.score.NormalScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.calculateScore;
import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.score.ScoreType.STRIKE;

public class NormalFrame implements Frame {
    private NormalScore normalScore;
    private String result;

    private NormalFrame(Score score) {
        normalScore = normalScore.generate(score);
        result = ScoreMachine.firstCalculate(normalScore);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return STRIKE.match(normalScore) || normalScore.hasSecondScore();
    }

    @Override
    public NormalFrame nextRound(Score secondScore) {
        if(!normalScore.validTotalScore(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }

        Optional<ScoreType> scoreType = calculateScore(normalScore.inScore(secondScore));
        result = scoreType.map(type -> convertScoreToString(type, normalScore)).get();

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public NormalScore getElement() {
        return normalScore;
    }
}
