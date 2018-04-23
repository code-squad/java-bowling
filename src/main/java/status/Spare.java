package status;

public class Spare implements State {
    private int first;

    public Spare(int first) {
        this.first = first;
    }

    @Override
    public String displayText() {
        return "|" + "/";
    }

    @Override
    public State bowl(int first) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }

//    public Spare(Pin firstPin, Pin secondPin) {
//        super(firstPin, secondPin);
//    }
//
//    public boolean spareCheck() {
//        if (getFirstPin().getPinFall() != Pin.getMaxFall() && (getFirstPin().getPinFall() + getSecondPin().getPinFall() == 10)) {
//            System.out.println("스페어");
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        return "/ ";
//    }


}
