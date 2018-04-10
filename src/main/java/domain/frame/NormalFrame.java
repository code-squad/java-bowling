package domain.frame;

import domain.Pins;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class NormalFrame implements Frame {
    private FrameStatus status;
    private Pins pins;
    private FrameScore score;

    public NormalFrame() {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    @Override
    public String recordPins(int num) throws IllegalArgumentException {
        pins.recordPins(num);
        status = status.changeStatus(pins);

        if (status.isFinish()) {
            score = new FrameScore(pins, status.getBonusCount());
        }

        return convertPinNum(num);
    }

    // recordBonusPins(int num) 해두고 isFinish() && !isBonusFinish() 인 애들한테만 전달 여기만?
    @Override
    public String recordBonusPins(int num) throws IllegalArgumentException {
        return null;
    }

    @Override
    public String convertPinNum(int num) {
        if (status.isFinish() && score.isStartedRecord()) {
            return null;
        }
        return status.convertScore(num);
    }

    @Override
    public boolean isFinish() {
        return status.isFinish();
    }

    @Override
    public boolean isBonusFinish() {
        return score.isSettingDone();
    }

    /* TODO : 계속 null이다가 점수가 다 들어올 시점에 Score 그대로 방출 */
    @Override
    public FrameScore getScore() {
        return null;
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
