package domain.frame;

public class LastFrame extends Frame {

    public LastFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) {
        score.roll(num);
        if (score.isBeforeBonusRoll()) { //roll을 가지고 다 기록한다는 전제하에 roll이 아닌 다른 인터페이스로 들어오면 isBonus()만 해도 됨 왜? 끝나고 여기 접근 안할거거든
            score.increaseLeftCount();
        }
        return this;
    }

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish() && score.isBonusFinish();
    }
}
