package saru;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    @Test(expected = IllegalArgumentException.class)
    public void ballCountFail() {
        DownPin.of(11);
    }

    @Test
    public void ballCount() {
        DownPin.of(0);
        DownPin.of(10);
    }

    @Test
    public void makeBalls() {
        Frame.of(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeBallsOverFour() {
        Frame.of(4);
    }

    @Test
    public void throwing() {
        Frame throwStatus = Frame.of(2);
        throwStatus.throwing(DownPin.of(5));
        assertEquals(DownPin.of(5), throwStatus.getThrowResult());
    }

    @Test
    public void nowThrowingTimes() {
        Frame throwStatus = Frame.of(2);
        throwStatus.throwing(DownPin.of(5));
        assertEquals(1, throwStatus.getNowThrowTimes());
    }
}
