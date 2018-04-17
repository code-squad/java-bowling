package bowling.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkPinExceptionTest() { // 스트라이크 후 2번째 3번째 핀의 합이 10초과
        Ball first = Ball.of(10);
        Ball second = Ball.of(5);
        LastFrame lastFrame = new LastFrame(Strike.of(first,second));

        lastFrame.playBonusBall(6);
    }
}