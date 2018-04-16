package domain;

public class NormalFrame extends Frame {
    private Pins first;
    private Pins second;
    State state;

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

    public State updateStatus() {
        if (first.isStrike()) {
            return state = new Strike();
        }
        if (second == null) {
            return state = new NotFinish();
        }
        first.isTotal(second);
        if (first.isSpare(second)) {
            return state = new Spare(first, second);
        }
        return state = new Open(first, second);
    }

    @Override
    public boolean isEnd() {
        return state.isEnd();
    }
}
