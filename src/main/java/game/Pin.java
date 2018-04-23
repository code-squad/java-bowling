//package game;
//
//public class Pin {
//    private int pinFall;
//    private static final int MAX_FALL = 10;
//    private static final int MIN_FALL = 0;
//
//    public Pin(int pinFall) {
//        if (pinFall > MAX_FALL || pinFall < MIN_FALL)
//            throw new IllegalArgumentException("입력값의 오류");
//        this.pinFall = pinFall;
//    }
//
//    public int getPinFall() {
//        return pinFall;
//    }
//
//    public boolean checkFinish() {
//        if (pinFall == MAX_FALL)
//            return true;
//        return false;
//    }
//
//    public static int getMaxFall() {
//        return MAX_FALL;
//    }
//
//    public static int getMinFall() {
//        return MIN_FALL;
//    }
//
//}
