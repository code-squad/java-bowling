package domain;

public class NormalFrame extends Frame {
    private Pins first;
    private Pins second;
    State state = new NotFinish();

    public NormalFrame(int no) {
        this(no, null, null);
    }

    public NormalFrame(int no, Pins first, Pins second) {
        super(no);
        this.first = first;
        this.second = second;
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
            return state = new Spare();
        }
        return state = new Open();
    }

    @Override
    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public String printState() {
        return state.printState(first, second);
    }
}
