package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Ball> balls = new ArrayList<>();

    public void playOneBall(int pin) {
        secondPinCheckException(pin);
        Ball ball = Ball.playOf(pin);
        balls.add(ball);
        frameCheckException();
    }

    public boolean isTwiceBall() {  //한 프레임에 두번쳤는지 확인
        if (balls.size() == 2) {
            return true;
        }
        return false;
    }

    public boolean isNewFrame() { //빈 프레임인지 확인
        if (balls.size() == 0) {
            return true;
        }
        return false;
    }

    public int firstInFrame() {
        return balls.get(0).getPin();
    }

    public int secondInFrame() {
        return balls.get(1).getPin();
    }

    public boolean isStrike() {
        return balls.get(0).isStrike();
    }

    public boolean isSpare() {
        return balls.get(1).isSpare(balls.get(0));
    }

    public void frameCheckException() {
        if (balls.size() > 2) {
            throw new IllegalArgumentException("한 프레임에 두번 이상 쳤습니다.");
        }
    }

    public void secondPinCheckException(int secondPin) {
        if (balls.size() == 1 && firstInFrame() + secondPin > 10) {
            throw new IllegalArgumentException("핀의 합계가 10을 초과 했습니다.");
        }
    }

    public static Frame next() {
        return new Frame();
    }
}
