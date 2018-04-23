//package status;
//
//import game.Pin;
//
//public class Missing extends Status {
//
//    public Missing(Pin firstPin, Pin seoncPin) {
//        super(firstPin, seoncPin);
//    }
//
//    public boolean checkMissing() {
//        if (getFirstPin() != null && getSecondPin().getPinFall() == 0) {
//            System.out.println("미싱");
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        return "- ";
//    }
//}
