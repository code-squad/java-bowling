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
        if (isRegularRecordFinish()) {
            return recordBonusPins(num);
        }
        pins.recordPins(num);
        status = status.changeStatus(pins);

        if (isRegularRecordFinish()) {
            score = new FrameScore(pins, status.getBonusCount());
        }
        return convertPinNum(num);
    }

    private String recordBonusPins(int num) throws IllegalArgumentException {
        score.addBonusPins(num);
        return convertPinNum(num);
    }

    private String convertPinNum(int num) {
        return doConvert(status, score, num);
    }

    abstract String doConvert(FrameStatus status, FrameScore score, int num);

    public boolean isRegularRecordFinish() {
        return status.isFinish();
    }

    public FrameScore getScore() {
        if (score == null || !score.isDone()) {
            return null;
        }
        return score;
    }

    public boolean isFinish() {
        return doCheckFinish(status, score);
    }

    abstract boolean doCheckFinish(FrameStatus status, FrameScore score);

    public boolean isRecordable() {
        return !isRegularRecordFinish() || !score.isDone();
    }
}
