package bowling.domain.frame;

import bowling.domain.ScoreMachine;
import bowling.domain.score.Score;

public class NormalFrame implements Frame {
    private FrameElement frameElement;
    private String result;

    private NormalFrame(Score score) {
        //optional
        frameElement = frameElement.generate(score);
        result = ScoreMachine.calculateStrike(frameElement);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return result != null;
    }

    @Override
    public Frame nextRound(Score secondScore) {
        if(!frameElement.canNextRound(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }
        result = ScoreMachine.calculateScore(frameElement.inScore(secondScore));

        return this;
    }

    @Override
    public String result() {
        return result;
    }
}
