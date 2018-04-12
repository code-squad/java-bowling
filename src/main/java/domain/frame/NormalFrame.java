package domain.frame;

public class NormalFrame extends Frame {

    public NormalFrame(int frameNum) {
        super(frameNum);
    }

    @Override
    Frame doRecord(FrameScore score, int num) {
        score.roll(num);
        if (isFinish()) {
            score.increaseLeftCount();
            return Frame.of(frameNum + 1);
        }
        return this;
    }

    // TODO : 보너스 점수는 다른 인터페이스를 만들어야할까? next를 주게해서 record를 같이 호출 못하게 해놨는데 Frame 상태 체크해서 보너스 상태인 인간들도 주기?

    @Override
    boolean doCheckFinish(FrameScore score) {
        return score.isRegularFinish();
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
