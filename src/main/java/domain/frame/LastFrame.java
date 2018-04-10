package domain.frame;

import domain.Pins;
import domain.frame.result.message.ScoreMessage;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public class LastFrame implements Frame {
    private FrameStatus status;
    private Pins pins;
    private FrameScore score;

    public LastFrame() {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    @Override
    public String recordPins(int score) throws IllegalArgumentException {
        if (status.isBonus()) {
            /*   bonusPin = new Pin(score);*/
            return convertPinNum(score);
        }
        pins.recordPins(score);
        status = status.changeStatus(pins);
        return convertPinNum(score);
    }

    @Override
    public String recordBonusPins(int num) throws IllegalArgumentException {
        return null;
    }

    @Override
    public String convertPinNum(int num) {
        if (status.isFinish()) {
            return ScoreMessage.convertMessage(num);
        }
        return status.convertScore(num);
    }

    @Override
    public boolean isFinish() {
        if (!status.isFinish()) {
            return false;
        }

        if (!status.isBonus()) {
            return true;
        }
        return isBonusFinish();
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
        return true;
    }
}
