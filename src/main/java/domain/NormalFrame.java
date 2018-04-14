package domain;

public class NormalFrame extends Frame {
    private Pin firstPins;
    private Pin secondPins;
    private Status status = Status.NOT_FINISHED;

    public NormalFrame() {

    }
//
//    public NormalFrame(Integer firstPins, Integer secondPins) {
//        throwing(createPin(firstPins), createPin(secondPins));
//    }
//
//    public void throwing(Pin firstPins, Pin secondPins) {
//        throwing(firstPins);
//        throwing(secondPins);
//    }

    public Pin createPin(Integer pins) {
        return new Pin(pins);
    }

    public int throwing(Pin throwingCount) {
        if (isFirst()) {
            firstPins = throwingCount;
            createStatus();
            return Pin.getSurvivedPin(throwingCount);
        }
        secondPins = throwingCount;
        createStatus();
        return Pin.getSurvivedPin(firstPins, secondPins);
    }

    public boolean isFirst() {
        return Pin.isBlank(firstPins) && Pin.isBlank(secondPins);
    }

    public boolean isSecond() {
        return !Pin.isBlank(firstPins) && Pin.isBlank(secondPins);
    }

    public Status createStatus() {
        if (Pin.isStrike(firstPins, secondPins)) {
            status = Status.STRIKE;
            return status;
        }
        if (!isSecond() && Pin.getSurvivedPin(firstPins, secondPins) == 0) {
            status = Status.SPARE;
            return status;
        }
        if (!isSecond() && Pin.getSurvivedPin(firstPins, secondPins) != 0) {
            status = Status.OPEN;
            return status;
        }
        status = Status.NOT_FINISHED;
        return status;
    }

    public boolean isStatus(Status status) {
        return this.status == status;
    }

    boolean isEnd() {
        return status != Status.NOT_FINISHED;
    }
}
