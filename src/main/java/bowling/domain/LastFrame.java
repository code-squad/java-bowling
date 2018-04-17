package bowling.domain;

public class LastFrame extends Frame {

    private Ball third;

    public LastFrame(FrameStatus frameStatus) {
        super(frameStatus);
    }

    public void playBonusBall(int pin) {
        checkPinException(pin);
        third = Ball.of(pin);
    }

    public boolean isThird() {
        return third == null;
    }

    public boolean isLastBall() {
        return getFrameStatus().isLastBall();
    }

    public int getThird() {
        return third.getPin();
    }

    public void checkPinException(int pin) {            //마지막 프레임에 스트라이크면 그 이후의 핀 확인
        if (getFrameStatus().getCount() == 2 &&getFrameStatus().getSecond()!=10 &&getFrameStatus().getSecond() + pin > 10) {
            throw new IllegalArgumentException("핀의 숫자보다 더 많이 입력하셨습니다.");
        }
    }
}
