package bowling.domain;

public class InCompleteFrame {

//    private Ball first;
//    private Ball second;
//
//    public void play(int pin) {
//        if (isFirst()) {
//            first = Ball.of(pin);
//            return;
//        }
//        checkSecondBallException(pin);
//        second = Ball.of(pin);
//    }
//
//    public FrameStatus check() {
//        if (isStrike()) {
//            return Strike.of(first, second);
//        }
//        if (isSpare()) {
//            return Spare.of(first, second);
//        }
//        return Miss.of(first, second);
//    }
//
//    public boolean checkComplete() {
//        if (first.isTenPin() || isTwiceBall()) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkLastFrameComplete() {
//        if (isTwiceBall()) {
//            return true;
//        }
//        return false;
//    }
//
//    public void checkSecondBallException(int pin){
//        if(!isStrike() && firstInFrame()+pin>10){
//            throw new IllegalArgumentException("핀의 합이 10을 초과하였습니다.");
//        }
//    }
//
//    public boolean isStrike() {
//        return first.isTenPin();
//    }
//
//    public boolean isSpare() {
//        return first.isSpare(second);
//    }
//
//    public boolean isFirst() {
//        return first == null;
//    }
//
//    public boolean isTwiceBall() {
//        return second != null;
//    }
//
//    public int firstInFrame() {
//        return first.getPin();
//    }
}
