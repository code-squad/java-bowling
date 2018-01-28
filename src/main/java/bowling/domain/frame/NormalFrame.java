package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;

import static bowling.domain.ScoreMachine.convertScore;
import static bowling.domain.score.type.NormalScoreType.STRIKE;

public class NormalFrame implements Frame {
    private EntireScore entireScore;

    private NormalFrame(Score score) {
        entireScore = entireScore.generate(score);
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
        entireScore.inScore(secondScore);
        return this;
    }

    @Override
    public String result() {
        return convertScore(entireScore);
    }
}
