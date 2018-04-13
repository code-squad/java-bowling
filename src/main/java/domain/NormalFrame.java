package domain;

public class NormalFrame extends Frame {
    private Integer firstPins;
    private Integer secondPins;
    private Status status;

    public NormalFrame(String name) {
        super(name);
    }

    public NormalFrame(Integer firstPins, Integer secondPins) {
        this("Guest");
        throwing(firstPins, secondPins);
    }

    public void throwing(int firstPins, int secondPins) {
        throwing(firstPins);
        throwing(secondPins);
    }

    @Override
    public int throwing(int throwingCount) {
        isValidThrowing(throwingCount);
        if (isFirst()) {
            firstPins = throwingCount;
            createStatus();
            return TEN_PINS - firstPins;
        }
        secondPins = throwingCount;
        createStatus();
        return TEN_PINS - firstPins - secondPins;
    }

    public boolean isValidThrowing(int throwingCount) {
        if (throwingCount > TEN_PINS) {
            throw new RuntimeException("쓰러트린 핀의 개수는 10개를 초과할 수 없습니다.");
        }
        if (!isFirst() && TEN_PINS - firstPins < throwingCount) {
            throw new RuntimeException("한 프레임에서 쓰러트린 모든 핀의 개수는 10개를 초과할 수 없습니다.");
        }
//        System.out.println("NormalFrame.isValidThrowing : true");
        return true;
    }

    public boolean isFirst() {
        return firstPins == null && secondPins == null;
    }

    public boolean isSecond() {
        return firstPins != null && secondPins == null;
    }

    public Status createStatus() {
        if (firstPins == TEN_PINS) {
            status = Status.STRIKE;
            return status;
        }
        if (!isSecond() && firstPins + secondPins == TEN_PINS) {
            status = Status.SPARE;
            return status;
        }
        status = Status.OPEN;
        return status;
    }

    public boolean isStatus(Status status) {
        return this.status == status;
    }

    public int getFirst() {
        return firstPins;
    }

    public int getSecond() {
        return secondPins;
    }
}
