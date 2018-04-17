package bowling.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {

    @Test(expected = IllegalArgumentException.class)
    public void overPinTest() {
        Ball ball = Ball.of(12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void underPinTest() {
        Ball ball = Ball.of(-1);
    }

    @Test
    public void isSpare() {
        Ball ball = Ball.of(5);
        Ball ball2 = Ball.of(5);
        assertEquals(ball.isSpare(ball2), true);
    }
}