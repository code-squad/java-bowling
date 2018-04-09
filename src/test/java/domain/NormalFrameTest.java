package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private NormalFrame frame;

    @Test
    public void isStrike() {
        frame = new NormalFrame(10, 0);
        assertTrue(frame.isStrike());
    }

    @Test
    public void isSpare() {
        frame = new NormalFrame(1, 9);
        assertTrue(frame.isSpare());
    }

}