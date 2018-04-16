package domain;

public class NormalFrame extends Frame {
    private Pins first;
    private Pins second;
    Status status;

    public NormalFrame(int no) {
        super(no);
    }

    public void throwing(int throwing) {
        if (first == null) {
            first = new Pins(throwing);
            return;
        }
        if (first != null) {
            second = new Pins(throwing);
        }
    }

    public Status updateStatus() {
        if (first.isStrike()) {
            return status = new Strike();
        }
        if (second == null) {
            return status = new NotFinish();
        }
        first.isTotal(second);
        if (first.isSpare(second)) {
            return status = new Spare(first, second);
        }
        return status = new Open(first, second);
    }

    @Override
    public boolean isEnd() {
        System.out.println(status.getClass().toString());
        return !status.getClass().equals(new NotFinish());
    }
}
