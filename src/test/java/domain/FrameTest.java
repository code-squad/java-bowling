package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {
    private Frame frame;

    @Test
    public void isStrike() {
        frame = new NormalFrame();
        frame.updateFrame(10);
        assertTrue(frame.isStrike());
    }

    @Test
    public void isSpare() {
        frame = new NormalFrame();
        frame.updateFrame(8);
        frame.updateFrame(2);
        assertTrue(frame.isSpare());
    }
}