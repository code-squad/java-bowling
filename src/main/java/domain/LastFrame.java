package domain;

public class LastFrame extends Frame {
    public LastFrame(int no) {
        super(no);
    }

    @Override
    public void throwing(int throwing) {

    }

    @Override
    public State updateStatus() {
        return null;
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
