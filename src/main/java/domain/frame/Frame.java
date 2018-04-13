package domain.frame;

import domain.frame.result.FrameResult;
import domain.frame.score.FrameScore;

import static domain.frame.result.Board.isLimit;

public abstract class Frame {
    public static final int REGULAR_COUNT = 2;
    public static final int UN_SCORE_STATE = -1;

    final int frameNum;
    private FrameScore score;
    private Frame nextFrame;

    public Frame(int frameNum) {
        this.frameNum = frameNum;
        score = new FrameScore(REGULAR_COUNT);
    }

    public static Frame of(int frameNum) {
        if (isLimit(frameNum)) {
            return new LastFrame(frameNum);
        }
        return new NormalFrame(frameNum);
    }

    public Frame roll(int num) throws IllegalArgumentException {
        // TODO : 보너스 프레임도 다같이 점수 등록되게 여기서 상태 잡아주는 것도(점수 등록 상태가 아닌 경우 넘기고 next가 있으면 doRecord 실행 없으면 자기 반환?
        Frame frame = doRecord(score, num);
        if (this != frame) {
            nextFrame = frame;
            return nextFrame;
        }
        return this;
    }

    abstract Frame doRecord(FrameScore score, int num) throws IllegalArgumentException;

    public boolean isFinish() {
        return doCheckFinish(score);
    }

    abstract boolean doCheckFinish(FrameScore score);

    public abstract boolean isLast();

    public int getFrameNum() {
        return frameNum;
    }

    public FrameResult getResult() {
        if (!score.isBonusFinish()) {
            return new FrameResult(score.getScoreMessage(), UN_SCORE_STATE);
        }
        // TODO : 보너스 점수 등록 부분 해결하고 여기 해결하기 뭔가 얹혀지는 느낌인
        return new FrameResult(score.getScoreMessage(), score.getScore());
    }
}
