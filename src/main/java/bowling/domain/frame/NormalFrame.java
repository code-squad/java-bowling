package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.ScoreMachine;
import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.calculateScore;
import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.score.ScoreType.STRIKE;

public class NormalFrame implements Frame {
    private EntireScore entireScore;
    private String result;

    private NormalFrame(Score score) {
        entireScore = entireScore.generate(score);
        result = ScoreMachine.firstCalculate(entireScore);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return STRIKE.match(entireScore) || entireScore.hasSecondScore();
    }

    @Override
    public NormalFrame nextRound(Score secondScore) {
        if(!entireScore.validTotalScore(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }

        Optional<ScoreType> scoreType = calculateScore(entireScore.inScore(secondScore));
        result = scoreType.map(type -> convertScoreToString(type, entireScore)).get();

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public EntireScore getElement() {
        return entireScore;
    }
}
