package domain.frame;

import domain.Pin;
import domain.Pins;
import domain.frame.result.ScoreMessage;
import domain.frame.status.FrameStatus;

public class LastFrame implements Frame {
    private FrameStatus status;
    private Pins pins;


    private Pin bonusPin;

    public LastFrame() {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    @Override
    public String recordPins(int score) throws IllegalArgumentException {
        if (status.isBonus()) {
            bonusPin = new Pin(score);
            return convertPinNum(score);
        }
        pins.recordPins(score);
        status = status.changeStatus(pins);
        return convertPinNum(score);
    }

    @Override
    public String convertPinNum(int num) {
        if (pins.isFinish()) {
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
        return bonusPin != null;
    }

    @Override
    public int getTotalScore() {
        return 0;
    }
}
