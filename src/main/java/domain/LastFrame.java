package domain;

public class LastFrame extends Frame {
    final int TEN_PINS = 10;

    Pins first;
    Pins second;
    Pins third;

    public LastFrame(int no) {
        super(no);
    }

    @Override
    public void throwing(int throwing) {
//        if (first == null) {
//            first = new Pins(throwing);
//            return;
//        }
//        if (first != null && second == null) {
//            second = new Pins(throwing);
//            return;
//        }
//        if (first != null && second != null && third == null) {
//            third = new Pins(throwing);
//        }
        if (Pins.isEmpty(first)) {
            first = new Pins(throwing);
            return;
        }
        if (Pins.isEmpty(second)) {
            second = new Pins(throwing);
            return;
        }
        if (Pins.isEmpty(third)) {
            third = new Pins(throwing);
        }
    }

    @Override
    public State updateStatus() {
        return null;
    }

    @Override
    public boolean isEnd() {
        return first.isOpen(second) || third != null;
    }

    @Override
    public String printState() {
        if (Pins.isEmpty(second)) {
            return first.print();
        }
        if (Pins.isEmpty(third)) {
            return second.print();
        }
        return null;
    }
}
