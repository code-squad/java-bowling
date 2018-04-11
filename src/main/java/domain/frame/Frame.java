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
        if (isBonus()) {
            return recordBonusPins(num);
        }
        pins.recordPins(num);
        status = status.changeStatus(pins);
        return convertPinNum(num);
    }

    private String recordBonusPins(int num) throws IllegalArgumentException {
        if (score == null) {
            score = new FrameScore(pins, status.getBonusCount());
        }
        score.addBonusPins(num);
        return convertPinNum(num);
    }

    private String convertPinNum(int num) {
        return doConvert(status, score, num);
    }

    abstract String doConvert(FrameStatus status, FrameScore score, int num);

    public boolean isFinish() {
        return doCheckFinish(status);
    }

    abstract boolean doCheckFinish(FrameStatus status);

    public FrameScore getScore() {
        if (score == null || !score.isSettingDone()) {
            return null;
        }
        return score;
    }

    public boolean isBonus() {
        return status.isBonus();
    }

    public boolean isBonusFinish() {
        return score.isSettingDone();
    }
}
