package bowling.domain.frame;

import bowling.domain.ScoreMachine;
import bowling.domain.score.Score;

import static bowling.domain.score.ScoreType.STRIKE;

public class NormalFrame implements Frame {
    private FrameElement frameElement;
    private String result;

    private NormalFrame(Score score) {
        frameElement = frameElement.generate(score);
        result = ScoreMachine.firstCalculate(frameElement);
    }

    public static NormalFrame generate(Score score) {
        return new NormalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return STRIKE.match(frameElement) || frameElement.hasSecondScore();
    }

    @Override
    public NormalFrame nextRound(Score secondScore) {
        if(!frameElement.canNextRound(secondScore)) { throw new IllegalArgumentException("2번째 투구점수가 올바르지 않습니다."); }
        result = ScoreMachine.calculateScore(frameElement.inScore(secondScore));

        return this;
    }

    @Override
    public String result() {
        return result;
    }

    public FrameElement getFrameElement() {
        return frameElement;
    }
}
