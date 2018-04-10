package domain.frame;

import domain.Pins;
import domain.frame.result.score.FrameScore;
import domain.frame.status.FrameStatus;

public abstract class Frame {
    private FrameStatus status;
    private Pins pins;
    private FrameScore score;

    public Frame() {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    public String recordPins(int num) throws IllegalArgumentException {
        pins.recordPins(num);
        status = status.changeStatus(pins);
        if (status.isFinish()) {
            score = new FrameScore(pins, status.getBonusCount());
        }
        return convertPinNum(num);
    }

    public String recordBonusPins(int num) throws IllegalArgumentException {
        score.addBonusPins(num);
        return convertPinNum(num);
    }

    public String convertPinNum(int num) {
        return doConvert(status, score, num);
    }

    abstract String doConvert(FrameStatus status, FrameScore score, int num);

    public boolean isFinish() {
        return doCheckFinish(status);
    }

    abstract boolean doCheckFinish(FrameStatus status);

    public boolean isBonusFinish() {
        return score.isSettingDone();
    }

    public FrameScore getScore() {
        if (!score.isSettingDone()) {
            return null;
        }
        return score;
    }

    public abstract boolean isLast();
}
