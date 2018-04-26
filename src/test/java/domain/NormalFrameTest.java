package domain;

import org.junit.Before;
import org.junit.Test;
import state.Ready;
import state.Strike;

import static org.junit.Assert.*;

public class NormalFrameTest {
    Frame frame;

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