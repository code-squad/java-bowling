package domain;

import org.junit.Before;
import org.junit.Test;
import state.Strike;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new NormalFrame(1);
    }

    @Test
    public void bowl() {
        assertTrue(Strike.isStrike(frame.bowl(new Pins(10))));
    }

    @Test
    public void isLastFrame() {
        assertFalse(frame.isLastFrame());
    }

    @Test
    public void isEnd() {
        frame.bowl(new Pins(10));
        assertTrue(frame.isEnd());
    }
}