package domain.frame;

import domain.Pins;
import domain.frame.status.FrameStatus;

public class NormalFrame implements Frame {
    private FrameStatus status;
    private Pins pins;

    public NormalFrame() {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    @Override
    public String recordPins(int num) throws IllegalArgumentException {
        pins.recordPins(num);
        status = status.changeStatus(pins);
        return convertPinNum(num);
    }

    @Override
    public String convertPinNum(int num) {
        return status.convertScore(num);
    }

    @Override
    public boolean isFinish() {
        return status.isFinish();
    }

    @Override
    public int getTotalScore() {
        return 0;
    }
}
