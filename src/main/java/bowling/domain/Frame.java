package bowling.domain;

public abstract class Frame {

    private Ball first;
    private Ball second;

    public void playOneBall(int pin) {
        if (isFirstNull()) {
            first = Ball.playOf(pin);
        } else {
            frameCheckException();
            first.secondPinCheckException(pin);
            second = Ball.playOf(pin);
        }
    }

    public boolean isTwiceBall() {  //한 프레임에 두번쳤는지 확인
        if (!isSecondNull()) {
            return true;
        }
        return false;
    }

    public boolean isNewFrame() { //빈 프레임인지 확인
        if (isFirstNull()) {
            return true;
        }
        return false;
    }

    public int firstInFrame() {
        return first.getPin();
    }

    public int secondInFrame() {
        return second.getPin();
    }

    public boolean isStrike() {
        return first.isStrike();
    }

    public boolean isSpare() {
        return first.isSpare(second);
    }

    public boolean isFirstNull() {
        return first == null;
    }

    public boolean isSecondNull() {
        return second == null;
    }

    public void frameCheckException() {
        if (!isSecondNull()) {
            throw new IllegalArgumentException("한 프레임에 두번 이상 쳤습니다.");
        }
    }
}
