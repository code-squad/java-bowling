package status;

public class Strike implements State {
    @Override
    public String displayText() {
        return "|" + "X";
    }

    @Override
    public State bowl(int first) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }


//    public Strike(Pin firstPin) {
//        super(firstPin);
//    }
//
//    public boolean checkStrike() {
//        if (getFirstPin().checkFinish() && getSecondPin() == null) {
//            System.out.println("스트라이크");
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        return "  X   ";
//    }
}
