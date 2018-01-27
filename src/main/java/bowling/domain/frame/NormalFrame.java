package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;

import static bowling.domain.ScoreMachine.convertScoreToString;
import static bowling.domain.score.ScoreType.STRIKE;

public class NormalFrame implements Frame {
    private EntireScore entireScore;
    private String result;

    private NormalFrame(Score score) {
        entireScore = entireScore.generate(score);
        result = convertScoreToString(entireScore);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return STRIKE.match(entireScore) || entireScore.length() == 2;
    }

    @Override
    public NormalFrame nextRound(Score secondScore) {
        if(!entireScore.validTotalScore(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }
        result = convertScoreToString(entireScore.inScore(secondScore));
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
